package Main.WebServices;

import Main.Model.Customer;
import Main.Model.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("/products")
public class ProductResources {
    @GET
    @Produces("application/json")
    public Response getAllProducts() {
        List<Product> gp = Product.getAllProducts();
        if (gp.isEmpty()) {
            var error = Map.of("error", "Er zijn geen producten.");
            return Response.status(409).entity(error).build();
        } else {
            return Response.ok(gp).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") int id) {
        Product product = Product.getProductById(id);
        if (product != null) {
            return Response.ok(product).build();
        } else {
            var error = Map.of("error", "Customer niet gevonden.");
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(Product product) {
        if (product.isValid()) {
            return Response.status(Response.Status.CREATED).entity(product).build();
        } else {
            var error = Map.of("error", "Verkeerde product data.");
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }
    }

    @Path("/cart")
    public class CartResource {
        private static List<Product> shoppingCart = new ArrayList<>();
        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response addToCart(Product product) {
            shoppingCart.add(product);
            return Response.ok().build();
        }
    }
}
