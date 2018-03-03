package controllers;

import entities.UserEntity;
import services.RestService;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/users")
public class UserController {

//    @Inject
//    private RestService rs;

    @Path("/all")
    @GET
    @Produces("application/json")
    public JsonArray getAll() {
        RestService rs = new RestService();
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (UserEntity u : rs.getAll()) {
            builder.add(
                    Json.createObjectBuilder()
                            .add("username", u.getUsername())
                            .add("password", u.getPassword())
            );
        }
        return builder.build();
    }
}
