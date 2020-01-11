package pl.dunski.springbootproduct.controllers;

import org.springframework.web.bind.annotation.*;
import pl.dunski.springbootproduct.models.ProductDB;
import pl.dunski.springbootproduct.services.ProductService;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Proste sprawdzenie usługi rest
    @GetMapping("/hello")
    public String testHello() {
        return "Hello Product Api Here";
    }

    // Metoda zwraca nam z basy danych wszystkie produkty
    @GetMapping("/get")
    public List<ProductDB> get() {
        return productService.get();
    }

    // Metoda ktora przyjmuje dane do utworzenia produktu
    @RequestMapping(value = "/creatProduct", method = RequestMethod.POST)
    @ResponseBody
    public int creatCustomer(@RequestBody ProductDB product) {
        return productService.creatProduct(product);
    }

    // Metoda ktora przyjmue liste nr kredytow dla ktorych ma zwrocic produkty
    @RequestMapping(value = "/getProducts", method = RequestMethod.POST)
    @ResponseBody
    public List<ProductDB> getProducts(@RequestBody List<Integer> creditNumbers) {
        return productService.getProducts(creditNumbers);
    }
}
