import Main.Model.Order;
import Main.WebServices.OrderResources;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    private Order order;

    @Test
    public void testGetAllOrdersWhenEmpty() {
        OrderResources orderResources = new OrderResources();

        Response response = orderResources.getAllOrders();

        assertEquals(Response.Status.CONFLICT.getStatusCode(), response.getStatus());

        assertTrue(response.getEntity() instanceof Map);
        Map<String, String> error = (Map<String, String>) response.getEntity();

    }

    @Test
    public void testGetAllOrdersWithExistingOrders() {
        OrderResources orderResources = new OrderResources();

        List<Order> orders = List.of(
                new Order(1, 100.0, "123 straat", "456 straat", new Date(), "Pending"),
                new Order(2, 200.0, "789 straat", "321 straat", new Date(), "Shipped")
        );

        orders.forEach(Order::addOrders);

        Response response = orderResources.getAllOrders();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        assertTrue(response.getEntity() instanceof List);
        List<Order> retrievedOrders = (List<Order>) response.getEntity();
    }

    @Test
    public void testCreateValidOrder() {
        OrderResources orderResources = new OrderResources();

        Order validOrder = new Order(1, 100.0, "123 Main St", "456 straat", new Date(), "Pending");

        Response response = orderResources.createOrder(validOrder);

        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());

        assertTrue(response.getEntity() instanceof Order);
        Order createdOrder = (Order) response.getEntity();
    }

    @Test
    public void testCreateInvalidOrder() {
        OrderResources orderResources = new OrderResources();

        Order invalidOrder = new Order(1, -100.0, "", "456 straat", new Date(), "Pending");

        Response response = orderResources.createOrder(invalidOrder);

        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());

        assertTrue(response.getEntity() instanceof Map);
        Map<String, String> error = (Map<String, String>) response.getEntity();
    }


    @Test
    public void testIsValidWithValidOrder() {
        Order validOrder = new Order(1, 100.0, "123 straat", "456 straat", new Date(), "Pending");

        boolean isValid = validOrder.isValid();

        assertTrue(isValid);
    }

    @Test
    public void testIsValidWithInvalidOrder() {
        Order invalidOrder = new Order(0, -100.0, "", "456 straat", new Date(), "Pending");

        boolean isValid = invalidOrder.isValid();

        assertFalse(isValid);
    }
}