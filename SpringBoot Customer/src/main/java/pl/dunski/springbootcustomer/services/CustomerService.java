package pl.dunski.springbootcustomer.services;

import org.springframework.stereotype.Service;
import pl.dunski.springbootcustomer.models.CustomerDB;
import pl.dunski.springbootcustomer.reposytories.CustomerReposytory;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private CustomerReposytory customerReposytory;

    public CustomerService(CustomerReposytory customerReposytory) {
        this.customerReposytory = customerReposytory;
    }

    // Metoda wyciagajaca klientow z bazy danych
    public List<CustomerDB> get() {
        return customerReposytory.findAll();
    }

    // Metoda ktora tworzy klienta w bazie danych (wysyła dane ktora baza danych tworzy Produkt)
    public int creatCustomer(CustomerDB customer) {
        return customerReposytory.save(customer);
    }

    // Metoda zwracajaca klientow ktorych id credytow podalismy. Domyslnie sa podawane wszystkie id kredytow wiec przekazywane takze sa wszyscy kilenci.
    public List<CustomerDB> getCustomers(List<Integer> creditNumbers) {

        List<CustomerDB> customers = new ArrayList<>();

        for (Integer creditNum : creditNumbers) {
            customers.add(customerReposytory.findbyId(creditNum).get());
        }

        return customers;
    }


    //Metoda zwracajaca wartosc boolean o istnieju klienta o podanym peselu
    public boolean getCustomerByPesel(String pesel) {
        if (customerReposytory.findbyPesel(pesel).isPresent()) {
            return false;
        } else {
            return true;
        }
    }
}
