package Main.Model;

import org.glassfish.jersey.internal.inject.Custom;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int customerId;
    private String name;
    private String email;
    private String address;
    private ArrayList orderHistory;
    private Payment betaling;
    private Order bestelling;
    private static List<Customer> allCustomers = new ArrayList<>();

    public Customer(int ci, String nm, String em, String ad){
        customerId = ci;
        name = nm;
        email = em;
        address = ad;
    }
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(ArrayList orderHistory) {
        this.orderHistory = orderHistory;
    }

    public Payment getBetaling() {
        return betaling;
    }

    public void setBetaling(Payment betaling) {
        this.betaling = betaling;
    }

    public static List<Customer> getAllCustomers() {
        return allCustomers;
    }

    public static void addCustomers(Customer customer) {
        allCustomers.add(customer);
    }

    public boolean isValid() {
        if (name == null || name.isEmpty()) {
            return false;
        }
        if (email == null || email.isEmpty()) {
            return false;
        }
        if (address == null || address.isEmpty()) {
            return false;
        }
        return true;
    }
}
