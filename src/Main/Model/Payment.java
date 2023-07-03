package Main.Model;

import java.util.ArrayList;
import java.util.List;

public class Payment {
    private static List<Payment> allPayments = new ArrayList<>();
    private int paymentId;
    private String paymentMethod;
    private Customer betaler;

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

    public static Payment getPaymentById(int paymentId) {
        for (Payment payment : allPayments) {
            if (payment.getPaymentId() == paymentId) {
                return payment;
            }
        }
        return null;
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

    public boolean isValid() {
        if (allPayments == null) {
            return false;
        }
        if (paymentId <= 0) {
            return false;
        }
        if (paymentMethod == null) {
            return false;
        }
        if (betaler == null) {
            return false;
        }

        return true;
    }

}
