import Model.Customer;
import Model.Order;
import Model.ProductRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OrderTest {
    private Order order;

    @BeforeEach
    public void setUp() {
        order = new Order();
    }

    @Test
    public void testGetOrderId() {
        // Arrange
        int expectedOrderId = 1;
        order.setOrderId(expectedOrderId);

        int actualOrderId = order.getOrderId();

        assertEquals(expectedOrderId, actualOrderId);
    }
}