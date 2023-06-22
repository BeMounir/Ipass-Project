package Main.Model;

import org.glassfish.jersey.internal.inject.Custom;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int customerId;
    private String name;
    private String password;
    private String email;
    private String address;
    private ArrayList orderHistory;
    private Payment allPayment;
    private String role;
    private List<Order> allOrders;
    private static final List<Customer> allCustomers = new ArrayList<>();

    public Customer(int ci, String nm, String pw, String em, String ad){
        customerId = ci;
        name = nm;
        password = pw;
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
        return allPayment;
    }

    public void setBetaling(Payment betaling) {
        this.allPayment = betaling;
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
        return address != null && !address.isEmpty();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public static Customer getCustomerById(int customerId) {
        for (Customer customer : allCustomers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;
    }
}
