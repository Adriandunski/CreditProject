package pl.dunski.springbootproduct.services;

import org.springframework.stereotype.Service;
import pl.dunski.springbootproduct.models.ProductDB;
import pl.dunski.springbootproduct.reposytories.ProductReposytory;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private ProductReposytory productReposytory;

    public ProductService(ProductReposytory productReposytory) {
        this.productReposytory = productReposytory;
    }

    // Metoda wyciagajaca wszyskie produkty z bazy danych
    public List<ProductDB> get() {
        return productReposytory.findAll();
    }

    // Metoda ktora tworzy produkt w bazie danych (wysyła dane ktora baza danych tworzy Produkt)
    public int creatProduct(ProductDB product) {
        return productReposytory.save(product);
    }

    // Metoda zwracajaca produkty ktorych id credytow podalismy. Domyslnie sa podawane wszystkie id kredytow wiec przekzaywane takze sa wszyscy kilenci.
    public List<ProductDB> getProducts(List<Integer> creditNumbers) {

        List<ProductDB> products = new ArrayList<>();

        for (Integer creditNum : creditNumbers) {
            products.add(productReposytory.findbyId(creditNum).get());
        }

        return products;
    }
}
