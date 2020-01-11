package pl.dunski.springbootproduct.models;

// Model klasy ktory uzywany jest do bazy danych a takze to wymiany z aplikacja SpringBoot Credit
public class ProductDB {

    private int creditID;
    private String productName;
    private int value;

    public ProductDB(int creditID, String productName, int value) {
        this.creditID = creditID;
        this.productName = productName;
        this.value = value;
    }

    public ProductDB() {
    }

    public int getCreditID() {
        return creditID;
    }

    public void setCreditID(int creditID) {
        this.creditID = creditID;
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
