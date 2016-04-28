package info.batey.djvm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class Service {

    @GET
    @Path("/callout")
    public String callout() {
        return "Hello there";
    }
}
