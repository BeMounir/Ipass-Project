package Main.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static List<Order> allOrders = new ArrayList<>();
    private int orderId;
    private double totalCost;
    private String shippingAddress;
    private String billingAddress;
    private Date orderDate;
    private String orderStatus;
    private Customer bestelling;

    public Order(int oI, double tC, String sA, String bA, Date oD, String oS) {
        orderId = oI;
        totalCost = tC;
        shippingAddress = sA;
        billingAddress = bA;
        orderDate = oD;
        orderStatus = oS;
    }

    public static List<Order> getAllOrders() {
        return allOrders;
    }

    public static void setAllOrders(List<Order> allOrders) {
        Order.allOrders = allOrders;
    }

    public static void addOrders(Order order) {
        allOrders.add(order);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public boolean isValid() {
        if (orderId <= 0) {
            return false;
        }
        if (totalCost <= 0) {
            return false;
        }
        if (shippingAddress == null || shippingAddress.isEmpty()) {
            return false;
        }
        if (billingAddress == null || billingAddress.isEmpty()) {
            return false;
        }
        if (orderDate == null) {
            return false;
        }

        return true;
    }
}
