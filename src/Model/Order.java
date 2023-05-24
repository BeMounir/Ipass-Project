package Model;

import java.util.Date;
import java.util.List;

public class Order {
    private String orderId;
    private List<Product> products;
    private double totalCost;
    private String shippingAddress;
    private String billingAddress;
    private String paymentMethod;
    private Date orderDate;
    private String orderStatus;
    private String trackingInformation;
    private String invoice;
}
