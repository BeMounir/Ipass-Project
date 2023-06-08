import Main.Model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OrderTest {
    private Order order;

    @Test
    public void testGetOrderId() {
        // Arrange
        int expectedOrderId = 1;
        order.setOrderId(expectedOrderId);

        int actualOrderId = order.getOrderId();

        assertEquals(expectedOrderId, actualOrderId);
    }
}