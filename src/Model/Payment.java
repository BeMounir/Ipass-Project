package Model;

import java.util.ArrayList;

public class Payment {
    private int customerId;
    private String paymentMethod;
    private ArrayList<Customer> alleCustomers;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
