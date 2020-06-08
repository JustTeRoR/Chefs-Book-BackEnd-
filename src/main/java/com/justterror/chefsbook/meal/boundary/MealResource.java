package com.justterror.chefsbook.meal.boundary;

import com.justterror.chefsbook.meal.entity.Meal;
import com.justterror.chefsbook.utils.Countries;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.GeneratedValue;
import javax.security.enterprise.SecurityContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.justterror.chefsbook.security.Constants.ADMIN;
import static com.justterror.chefsbook.security.Constants.USER;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@ApplicationScoped
@Path("/meal")
public class MealResource {

    @Inject
    Logger logger;

    @Inject
    private SecurityContext securityContext;

    @Inject
    private MealService mealService;

    @GET
    @Path("/")
    @RolesAllowed({USER, ADMIN})
    @Produces(MediaType.APPLICATION_JSON)
    public List<Meal> list()
    {
        logger.info("Get all meals");
        return mealService.getAll();
    }

    @GET
    @Path("mealId/{id}")
    @RolesAllowed({USER, ADMIN})
    @Produces(MediaType.APPLICATION_JSON)
    public Meal getById(@PathParam("id") long id) {
        logger.info("Get meal with id " + id);
        return mealService.getById(id);
    }

    @GET
    @Path("country/{country}")
    @RolesAllowed({USER, ADMIN})
    @Produces(MediaType.APPLICATION_JSON)
    public List<Meal> getByCountry(@PathParam("country") Countries country) {
        logger.info("Get meals for country - " + country.toString());
        return mealService.getByCountry(country);
    }


/*
    @GET
    @Path("read")
    @PermitAll
    public Response read() {
        logger.log(Level.INFO, "read");
        JsonObject result = Json.createObjectBuilder()
                .add("user", securityContext.getCallerPrincipal() != null
                        ? securityContext.getCallerPrincipal().getName() : "Anonymous")
                .add("message", "Read resource")
                .build();
        return Response.ok(result).build();
    }

    @GET
    @Path("write")
    @RolesAllowed({USER, ADMIN})
    @Produces(MediaType.APPLICATION_JSON)
    public List<Meal> write() {
        logger.log(Level.INFO, "write");
        return mealService.getAll();
    }
*/
}
