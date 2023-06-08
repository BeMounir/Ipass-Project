package Main.Model;

import java.util.ArrayList;

public class Payment {
    private int paymentId;
    private String paymentMethod;
    private ArrayList<Customer> alleCustomers;

    public Payment(int pI, String pM) {
        paymentId = pI;
        paymentMethod = pM;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setCustomerId(int customerId) {
        this.paymentId = customerId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
