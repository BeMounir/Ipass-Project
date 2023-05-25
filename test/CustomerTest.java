import Model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer();
    }

    @Test
    public void testGetCustomerId() {
        int expectedId = 1;
        customer.setCustomerId(expectedId);

        int actualId = customer.getCustomerId();

        assertEquals(expectedId, actualId);
    }
}