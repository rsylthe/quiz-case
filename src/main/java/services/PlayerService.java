package services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created on 20.09.2017.
 *
 * @author Roy Åne Sylthe
 * @version 0.1.0
 */
@Path("/player/")
public class PlayerService {

    //TODO: Do something for this
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getSomething() {
        return "Hei!";
    }

    //TODO: Do something for this
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void putSomething() {
    }

    //TODO: Do something for this
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postSomething() {
    }

    //TODO: Do something for this
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteSomething() {
    }
}
