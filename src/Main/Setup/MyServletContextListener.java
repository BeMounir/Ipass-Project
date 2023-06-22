package Main.Setup;

import Main.Model.Customer;
import Main.Model.Order;
import Main.Model.Payment;
import Main.Model.Product;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Date;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    private static final String BASE_DIRECORY = determineBaseDirectory();
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Server started");

        Customer customer1 = new Customer(1, "bob", "wachtwoord1","bob@gmail.com", "capelle a/d bob");
        Customer customer2 = new Customer(2, "sam", "wachtwoord2","sam@gmail.com", "Nieuwekerk a/d sam");

        Order order1 = new Order(1, 12.1, "test shippingAdress", "test billingAdress", new Date(), "test orderstatus");
        Payment payment1 = new Payment(1, "creditcard");

        String[] testArray = {"schoen4.png", "image2.jpg", "image3.jpg"};
        Product product1 = new Product(1, "sneaker", "test description", "nike", 160.99, "geel", "XL", testArray);
        Customer.addCustomers(customer1);
        Customer.addCustomers(customer2);
        Order.addOrders(order1);
        Payment.addPayments(payment1);
        Product.addProducts(product1);
        determineBaseDirectory();
    }

    public static String determineBaseDirectory() {


        return BASE_DIRECORY;
    }

    public static String getBaseDirectory() {
        return BASE_DIRECORY;
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Shutdown received");
    }
}
