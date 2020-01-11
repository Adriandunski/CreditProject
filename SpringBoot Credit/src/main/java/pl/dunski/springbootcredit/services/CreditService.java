package pl.dunski.springbootcredit.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.dunski.springbootcredit.models.CreditFulInfo;
import pl.dunski.springbootcredit.models.Customer;
import pl.dunski.springbootcredit.models.Product;
import pl.dunski.springbootcredit.models.DataComing;
import pl.dunski.springbootcredit.models.modelsDB.CreditDB;
import pl.dunski.springbootcredit.models.modelsDB.CustomerDB;
import pl.dunski.springbootcredit.models.modelsDB.ProductDB;
import pl.dunski.springbootcredit.reposytories.CreditReposytory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CreditService {

    private CreditReposytory creditReposytory;
    private RestTemplate restTemplate = new RestTemplate();

    public CreditService(CreditReposytory creditReposytory) {
        this.creditReposytory = creditReposytory;
    }

    //Metoda wuciagajaca z bazy danych Kredyty.
    public List<CreditDB> get() {
        return creditReposytory.findAll();
    }

    // Metoda tworzaca caly kredyt
    public int creatCredit(DataComing testDataComing) {

        CreditDB creditDB;
        Optional<CreditDB> temp;

        // Mało prawdopodobne ale jezeli nr kredytu sie powtorzy stworz Credyt jeszcze raz z nowym id
        // Zakładam ze id kredytu musi byc unikalne
        do {
            creditDB = new CreditDB(testDataComing.getCreditName());
            temp = creditReposytory.findbyId(creditDB.getId());
        } while (temp.isPresent());

        creatCustomer(testDataComing, creditDB.getId());
        creatProduct(testDataComing, creditDB.getId());

        creditReposytory.save(creditDB);
        return creditDB.getId();
    }

    // Metoda przesyłająca informacje dla tworzenia produkt do SpringBoot Product
    private void creatProduct(DataComing testDataComing, int credit_id) {

        ProductDB product = new ProductDB(credit_id, testDataComing.getProductName(), testDataComing.getProductValue());
        restTemplate.postForObject("http://productapi:8081/creatProduct", product, Integer.class);
    }

    // Metoda przesyłająca informacje dla tworzenia customera do SpringBoot Customer
    private void creatCustomer(DataComing testDataComing, int credit_id) {

        CustomerDB customer = new CustomerDB(credit_id, testDataComing.getCustomerName(), testDataComing.getCustomerLast(), testDataComing.getCustomerPesel());
        restTemplate.postForObject("http://customerapi:8082/creatCustomer", customer, Integer.class);
    }

    //Metoda zbierajca wszystkie dane w jedno miejce
    public List<CreditFulInfo> getCreditsFull() {

        // Tutaj tworzymy prosty HttpEntity. Pakujemy mu nr kredytow dla ktorych chcemy otrzymac liste produktow i customerow.
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> request = new HttpEntity<>(creditReposytory.getCreditNumbersID(), httpHeaders);

        // Przygotowanie juz listy dla kompletnych kredytow wraz z produktami i klientami
        List<CreditFulInfo> creditFulInfos = new ArrayList<>();

        // Pobranie produktow i klientow z baz danych. (Z listy nr kredytów. Lista jak na razie zawiera wszystkie nr kredytow obecnych w bazie danych)
        List<ProductDB> products = getProducts(request);
        List<CustomerDB> customers = getCustomers(request);

        // Pętla ktora uklada wszystkie informacje w calosc.
        for (CreditDB tempCreditDB : get()) {
            CreditFulInfo creditFulInfo = new CreditFulInfo();
            creditFulInfo.setCreditName(tempCreditDB.getCreditName());

            for (CustomerDB tempCustomer : customers) {
                if (tempCustomer.getCreditID() == tempCreditDB.getId()) {
                    creditFulInfo.setCustomer(new Customer(tempCustomer.getFirstName(), tempCustomer.getLastName(), tempCustomer.getPesel()));
                }
            }

            for (ProductDB tempProduct : products) {
                if (tempProduct.getCreditID() == tempCreditDB.getId()) {
                    creditFulInfo.setProduct(new Product(tempProduct.getProductName(), tempProduct.getValue()));
                }
            }
            creditFulInfos.add(creditFulInfo);
        }

        return creditFulInfos;
    }

    //Metoda pobierajaca produkty z SpringBoot Products
    private List<ProductDB> getProducts(HttpEntity<Object> request) {

        ResponseEntity<List<ProductDB>> rateResponse = restTemplate.exchange("http://productapi:8081/getProducts",
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<List<ProductDB>>() {});
        return rateResponse.getBody();
    }

    //Metoda pobierajaca customery z SpringBoot Customer
    private List<CustomerDB> getCustomers(HttpEntity<Object> request) {
        ResponseEntity<List<CustomerDB>> rateResponse = restTemplate.exchange("http://customerapi:8082/getCustomers",
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<List<CustomerDB>>() {});
        return rateResponse.getBody();
    }

    // Metoda ktora pozwala nam sprawdzic czy istnieje klient o podanym peselu w bazie danych Aplikacji SpringBoot Customer
    public boolean ifCustomerExist(String pesel) {
        return restTemplate.postForObject("http://customerapi:8082/ifExist", pesel, Boolean.class);
    }
}