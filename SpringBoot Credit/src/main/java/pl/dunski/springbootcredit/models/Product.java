package pl.dunski.springbootcredit.models;

// Klase tą wykorzystuje klasa CreditFullInfo. Przychodzace dane z aplikacji SpringBoot Product mapujemy na taka klase.
public class Product {

    private String productName;
    private int value;

    public Product(String productName, int value) {
        this.productName = productName;
        this.value = value;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
