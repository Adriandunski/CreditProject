package pl.dunski.springbootcustomer.controllers;

import org.springframework.web.bind.annotation.*;
import pl.dunski.springbootcustomer.models.CustomerDB;
import pl.dunski.springbootcustomer.services.CustomerService;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Proste sprawdzenie usługi rest
    @GetMapping("/hello")
    public String testHello() {
        return "Hello Customer Api Here";
    }

    // Metoda zwraca nam z basy danych wszystkich klientow
    @GetMapping("/get")
    public List<CustomerDB> get() {
        return customerService.get();
    }

    // Metoda ktora przyjmuje dane do utworzenia klienta
    @RequestMapping(value = "/creatCustomer", method = RequestMethod.POST)
    @ResponseBody
    public int creatCustomer(@RequestBody CustomerDB customer) {
        return customerService.creatCustomer(customer);
    }

    // Metoda ktora przyjmue liste nr kredytow dla ktorych mamy zwrocic klientow
    @RequestMapping(value = "/getCustomers", method = RequestMethod.POST)
    @ResponseBody
    public List<CustomerDB> getProducts(@RequestBody List<Integer> creditNumbers) {
        return customerService.getCustomers(creditNumbers);
    }

    // Metoda zwraca warunek czy pesel klienta istnieje dla potrzeb klasy SpringBoot Credit
    @RequestMapping(value = "/ifExist", method = RequestMethod.POST)
    @ResponseBody
    public boolean ifExistPesel(@RequestBody String pesel) {
        return customerService.getCustomerByPesel(pesel);
    }
}