package pl.dunski.springbootcredit.models.modelsDB;

import java.security.SecureRandom;

// Klasa którą obsługujemy do wysyłania Credytu do bazny danych w tym przypadku coś jak szkielet
public class CreditDB {

    private String creditName;
    private int id;

    public CreditDB(String creditName) {
        this.creditName = creditName;
        this.id = generatorID();
    }

    public CreditDB(int id, String creditName) {
        this.id = id;
        this.creditName = creditName;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int generatorID() {
        SecureRandom random = new SecureRandom();
        return random.nextInt(999_999_999) + 1;
    }
}
