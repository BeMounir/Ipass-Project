package Main.Model;

import java.util.ArrayList;
import java.util.List;

public class Payment {
    private int paymentId;
    private String paymentMethod;
    private Customer betaler;
    private static List<Payment> allPayments = new ArrayList<>();

    public Payment(int pI, String pM) {
        paymentId = pI;
        paymentMethod = pM;
    }

    public static List<Payment> getAllPayments() {
        return allPayments;
    }

    public static void addPayments(Payment payment) {
        allPayments.add(payment);
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
