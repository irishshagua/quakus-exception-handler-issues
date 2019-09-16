package demo;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

@Path("/failable")
public class FailableResource {

    @Inject
    @RestClient
    private SomeRestClient restClient;

    @GET
    @Path("/bug")
    @Produces(MediaType.TEXT_PLAIN)
    public String fails() {
        return restClient.getAgainstNonExistingPath();
    }

    @GET
    @Path("/works1")
    @Produces(MediaType.TEXT_PLAIN)
    public String worksButRequiresControllerTryCatch() {
        try {
            return restClient.getAgainstNonExistingPath();
        } catch (WebApplicationException e) {
            throw new IllegalStateException("Is handled by the Exception Mapper if wrapped", e);
        }
    }

    @GET
    @Path("/works2")
    @Produces(MediaType.TEXT_PLAIN)
    public String worksIfThrownInMyCode() {
        throw new WebApplicationException("Hanlded by ExceptionMapper if not thrown by RestClient");
    }

    @GET
    @Path("/works3")
    @Produces(MediaType.TEXT_PLAIN)
    public String worksForOtherExceptions() {
        throw new IllegalStateException("This is handled correctly in the ExceptionMapper");
    }
}