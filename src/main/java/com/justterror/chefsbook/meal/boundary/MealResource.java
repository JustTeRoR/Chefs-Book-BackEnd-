package com.justterror.chefsbook.meal.boundary;

import com.justterror.chefsbook.meal.entity.Meal;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
@Path("/meal")
public class MealResource {

    @Inject
    Logger logger;

    @Inject
    private MealService mealService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Meal> list()
    {
        logger.info("Get all meals");
        return mealService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Meal getById(@PathParam("id") long id)
    {
        logger.info("Get meal with id " + id);
        return mealService.getById(id);
    }
}
