package com.justterror.chefsbook.user.boundary;

import com.justterror.chefsbook.meal.boundary.MealService;
import com.justterror.chefsbook.meal.entity.Meal;
import com.justterror.chefsbook.security.JWTAuthenticationMechanism;
import com.sun.deploy.association.RegisterFailedException;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

import static com.justterror.chefsbook.security.Constants.ADMIN;
import static com.justterror.chefsbook.security.Constants.USER;

@ApplicationScoped
@Path("/user")
public class UserResource {

    @Inject
    Logger logger;

    @Inject
    private SecurityContext securityContext;

    @Inject
    private UserService userService;

    @POST
    @Path("/login/{username}&{password}")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(@PathParam("username") String username, @PathParam("password") String password)  {
        logger.info("Login user");
        userService.login(username, password);
        return Response.ok().build();

    }

    @POST
    @Path("/login/{username}&{password}")
    @PermitAll
    public Response registerUser(@PathParam("username") String username, @PathParam("password") String password)  {
        logger.info("Register new person");
        userService.register(username, password);
        return Response.ok().build();
    }
}
