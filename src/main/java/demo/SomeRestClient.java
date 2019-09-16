package demo;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
@RegisterRestClient(baseUri="http://www.example.com")
public interface SomeRestClient {

    @GET
    @Path("/sub")
    String getAgainstNonExistingPath();
}
