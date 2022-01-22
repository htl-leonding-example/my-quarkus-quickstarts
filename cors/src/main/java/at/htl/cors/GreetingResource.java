package at.htl.cors;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("/hello")
public class GreetingResource {

    @Inject
    Logger LOG;

    @Context
    HttpHeaders requestHeaders;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello() {
        for (String key : requestHeaders.getRequestHeaders().keySet()) {
            LOG.infof("%s: %s", key, requestHeaders.getRequestHeader(key));
        }
        Response resp =  Response.ok("Hello, HTL Leonding").build();
        LOG.infof("Response-Headers");
        LOG.infof("Anzahl Headers: ", resp.getHeaders().keySet().size());
        for (String key : resp.getHeaders().keySet()) {
            LOG.infof("%s -> %s", key, resp.getHeaders().get(key));
        }
        return resp;
    }
}