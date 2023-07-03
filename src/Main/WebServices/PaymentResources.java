package Main.WebServices;

import Main.Model.Payment;
import Main.Model.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PaymentResources {
    @Path("/payments")
    public class PaymentResource {
        @GET
        @Produces("application/json")
        public Response getAllPayments() {
            List<Payment> gp = Payment.getAllPayments();
            if (gp.isEmpty()) {
                var error = Map.of("error", "Er zijn geen Payments.");
                return Response.status(409).entity(error).build();
            } else {
                return Response.ok(gp).build();
            }
        }

        @GET
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getProduct(@PathParam("id") int id) {
            Payment payment = Payment.getPaymentById(id);
            if (payment != null) {
                return Response.ok(payment).build();
            } else {
                var error = Map.of("error", "Customer niet gevonden.");
                return Response.status(Response.Status.NOT_FOUND).entity(error).build();
            }
        }

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response createPayment(Payment payment) {
            if (payment.isValid()) {
                return Response.status(Response.Status.CREATED).entity(payment).build();
            } else {
                var error = Map.of("error", "Verkeerde product data.");
                return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
            }
        }

        @Path("/aymentsCart")
        public class PaymentCartResource {
            private static final List<Payment> paymentsCart = new ArrayList<>();

            @POST
            @Consumes(MediaType.APPLICATION_JSON)
            @Produces(MediaType.APPLICATION_JSON)
            public Response paymentCart(Payment payment) {
                paymentsCart.add(payment);
                return Response.ok().build();
            }
        }
    }
}
