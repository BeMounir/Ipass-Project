package Main.Setup;

import Main.Model.Customer;
import Main.Model.Order;
import Main.Model.Payment;
import Main.Model.Product;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.lang.reflect.Array;
import java.util.Date;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Server started");
        Customer customer1 = new Customer(1, "bob", "bob@gmail.com", "capelle a/d bob");
        Order order1 = new Order(1, 12.1, "test shippingAdress", "test billingAdress", new Date(), "test orderstatus");
        Payment payment1 = new Payment(1, "creditcard");

        String[] testArray = {"schoen4.png", "image2.jpg", "image3.jpg"};
        Product product1 = new Product(1, "sneaker", "test description", "nike", 160.99, "geel", "XL", testArray);
        Customer.addCustomers(customer1);
        Order.addOrders(order1);
        Payment.addPayments(payment1);
        Product.addProducts(product1);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Shutdown received");
    }
}
