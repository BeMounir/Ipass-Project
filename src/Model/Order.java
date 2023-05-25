package Model;

import java.util.Date;
import java.util.List;

public class Order {
    private String orderId;
    private double totalCost;
    private String shippingAddress;
    private String billingAddress;
    private Date orderDate;
    private String orderStatus;
    private Customer aankoop;
    private ProductRule deProductRule;
}
