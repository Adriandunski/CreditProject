package pl.dunski.springbootcredit.models;


import pl.dunski.springbootcredit.validators.interfaces.CustomNotNull;
import pl.dunski.springbootcredit.validators.interfaces.Pesel;
import pl.dunski.springbootcredit.validators.interfaces.PeselChars;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DataComing {

    @CustomNotNull
    private String customerName;

    @CustomNotNull
    private String customerLast;

    @CustomNotNull
    @Size(max = 11, min = 11)
    @PeselChars
    @Pesel
    private String customerPesel;

    @CustomNotNull
    private String productName;

    @NotNull
    @Min(1)
    private int productValue;

    @CustomNotNull
    private String creditName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerLast() {
        return customerLast;
    }

    public void setCustomerLast(String customerLast) {
        this.customerLast = customerLast;
    }

    public String getCustomerPesel() {
        return customerPesel;
    }

    public void setCustomerPesel(String customerPesel) {
        this.customerPesel = customerPesel;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductValue() {
        return productValue;
    }

    public void setProductValue(int productValue) {
        this.productValue = productValue;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    @Override
    public String toString() {
        return "DataComing{" +
                "customerName='" + customerName + '\'' +
                ", customerLast='" + customerLast + '\'' +
                ", customerPesel='" + customerPesel + '\'' +
                ", productName='" + productName + '\'' +
                ", productValue=" + productValue +
                ", creditName='" + creditName + '\'' +
                '}';
    }
}
