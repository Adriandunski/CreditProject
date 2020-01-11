package pl.dunski.springbootcredit.models.modelsDB;

// Klasa którą obsługujemy do wysyłania danych na temat Customera do aplikacji SpirnBoot Customer.
public class CustomerDB {

    private int creditID;
    private String firstName;
    private String lastName;
    private String pesel;

    public CustomerDB() {
    }

    public CustomerDB(int creditID, String firstName, String lastName, String pesel) {
        this.creditID = creditID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    public int getCreditID() {
        return creditID;
    }

    public void setCreditID(int creditID) {
        this.creditID = creditID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
