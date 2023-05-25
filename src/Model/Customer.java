package Model;

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
}
