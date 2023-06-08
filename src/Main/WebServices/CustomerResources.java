package Main.WebServices;

import Main.Model.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;


@Path("/customers")
public class CustomerResources {
    @GET
    @Produces("application/json")
    public Response getAllCustomers() {
        System.out.println("test");
        List<Customer> cp = Customer.getAllCustomers();
        if (cp.isEmpty()) {
            var error = Map.of("error", "Er zijn geen customers.");
            return Response.status(409).entity(error).build();
        } else {
            return Response.ok(cp).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer customer) {
        if (customer.isValid()) {
            return Response.status(Response.Status.CREATED).entity(customer).build();
        } else {
            var error = Map.of("error", "Verkeerde customer data.");
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }
    }
}
