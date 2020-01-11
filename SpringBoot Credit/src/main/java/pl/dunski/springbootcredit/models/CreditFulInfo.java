package pl.dunski.springbootcredit.models;

// Klasa do zbierania informacji o wszystkich kredytach. (Lączymy w jedna calosc)
public class CreditFulInfo {

    private String creditName;
    private Customer customer;
    private Product product;

    public CreditFulInfo(String creditName, Customer customer, Product product) {
        this.creditName = creditName;
        this.customer = customer;
        this.product = product;
    }

    public CreditFulInfo() {
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
