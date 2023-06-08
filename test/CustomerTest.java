import Main.Model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer(1, "bob", "bob@gmail.com", "capelle a/d bob");
    }

    @Test
    public void testGetCustomerId() {
        int expectedId = 1;
        customer.setCustomerId(expectedId);

        int actualId = customer.getCustomerId();

        assertEquals(expectedId, actualId);
    }
}