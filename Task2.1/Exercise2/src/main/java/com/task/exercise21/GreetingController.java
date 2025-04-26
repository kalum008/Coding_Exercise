package com.task.exercise21;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/greet")
public class GreetingController {

    @Inject
    GreetingService greetingService;

    @GET
    @Path("/{name}")
    public Response greet(@PathParam("name") String name , @QueryParam("suffix") String suffix){
        return Response.ok(greetingService.greet(name,suffix)).build();
    }
}
