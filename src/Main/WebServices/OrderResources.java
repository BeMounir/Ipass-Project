package Main.WebServices;

import Main.Model.Order;
import Main.Model.Product;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class OrderResources {
    @GET
    @Produces("application/json")
    public Response getAllOrders() {
        List<Order> op = Order.getAllOrders();
        if (op.isEmpty()) {
            var error = Map.of("error", "Er zijn geen orders.");
            return Response.status(409).entity(error).build();
        } else {
            return Response.ok(op).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrder(Order order) {
        if (order.isValid()) {
            return Response.status(Response.Status.CREATED).entity(order).build();
        } else {
            var error = Map.of("error", "Verkeerde product data.");
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }
    }
}
