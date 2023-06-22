package Main.Security;

import Main.Model.Customer;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.util.AbstractMap;
import java.util.Calendar;

@Path("/login")
public class AuthenticationResource {
    public static Key key = MacProvider.generateKey();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginWebservice(AuthenticationRequest loginData) {
        System.out.println(loginData.username);
        System.out.println(loginData.password);
        for (Customer customer : Customer.getAllCustomers()) {

            System.out.println(loginData.username);
            System.out.println(loginData.password);

            if (customer.getName().equals(loginData.username) &&
                    customer.getPassword().equals(loginData.password)) {

                String jwt = Jwts.builder()
                        .setSubject(loginData.username)
                        .claim("role", customer.getRole())
                        .signWith(SignatureAlgorithm.HS512, key)
                        .compact();
                return Response.ok(new AbstractMap.SimpleEntry<>("JWT-token", jwt)).build();
            }
        }

        return Response.status(406).build();
    }
}