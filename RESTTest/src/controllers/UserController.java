package controllers;

import entities.UserEntity;
import services.RestService;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/users")
public class UserController {

//    Injection not working
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

    @Path("/{id}")
    @GET
    @Produces("application/json")
    public JsonObject getFromId(@PathParam("id") int id) {
        RestService rs = new RestService();
        UserEntity u = rs.getFromId(id);
        return Json.createObjectBuilder()
                .add("username", u.getUsername())
                .add("password", u.getPassword()).build();
    }

}
