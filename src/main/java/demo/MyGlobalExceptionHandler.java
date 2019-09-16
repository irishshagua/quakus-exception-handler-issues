package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyGlobalExceptionHandler implements ExceptionMapper<Throwable> {

    private static final Logger log = LoggerFactory.getLogger(MyGlobalExceptionHandler.class);

    @Override
    public Response toResponse(Throwable throwable) {
        log.error("Caught and handled in the Global Exception handler", throwable);
        return Response.ok().build(); // 200 only used for illustrative purposes
    }
}
