import Main.Model.Customer;
import Main.WebServices.CustomerResources;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer(1, "bob", "wacthwoord1","bob@gmail.com", "capelle a/d bob");
    }

    @Test
    public void testGetCustomerId() {
        int expectedId = 1;
        customer.setCustomerId(expectedId);

        int actualId = customer.getCustomerId();

        assertEquals(expectedId, actualId);
    }

    @Test
    public void testGetAllCustomersWithExistingCustomers() {
        CustomerResources customerResources = new CustomerResources();

        List<Customer> customers = List.of(
                new Customer(1, "Testnaam1", "wachtwoord1","Test1@email.com", "123 straat"),
                new Customer(2, "Testnaam2", "wachtwoord1","Test1@email.com", "456 straat")
        );

        customers.forEach(Customer::addCustomers);

        Response response = customerResources.getAllCustomers();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        assertTrue(response.getEntity() instanceof List);
        List<Customer> retrievedCustomers = (List<Customer>) response.getEntity();

    }

    @Test
    public void testCreateValidCustomer() {
        CustomerResources customerResources = new CustomerResources();

        Customer customer = new Customer(1, "John Doe", "wachtwoord1","johndoe@example.com", "123 Main St");

        Response response = customerResources.createCustomer(customer);

        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());

        assertTrue(response.getEntity() instanceof Customer);
        Customer createdCustomer = (Customer) response.getEntity();
    }

    @Test
    public void testCreateInvalidCustomer() {
        CustomerResources customerResources = new CustomerResources();

        Customer invalidCustomer = new Customer(1, "", "wachtwoord1","email", "123 straat");

        Response response = customerResources.createCustomer(invalidCustomer);

        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());

        assertTrue(response.getEntity() instanceof Map);
        Map<String, String> error = (Map<String, String>) response.getEntity();
    }
    @Test
    public void testIsValidWithValidCustomer() {
        Customer validCustomer = new Customer(1, "John Doe", "wachtwoord1","johndoe@example.com", "123 Main St");

        boolean isValid = validCustomer.isValid();

        assertTrue(isValid);
    }

    @Test
    public void testIsValidWithInvalidCustomer() {
        Customer invalidCustomer = new Customer(1, "", "wachtwoord1","testemail", "123 straat");

        boolean isValid = invalidCustomer.isValid();

        assertFalse(isValid);
    }
}