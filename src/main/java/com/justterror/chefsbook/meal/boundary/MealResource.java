package com.justterror.chefsbook.meal.boundary;

import com.justterror.chefsbook.meal.entity.Meal;
import com.justterror.chefsbook.utils.Categories;
import com.justterror.chefsbook.utils.Countries;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;
import static com.justterror.chefsbook.security.Constants.ADMIN;
import static com.justterror.chefsbook.security.Constants.USER;

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
    @GET
    @Path("category/{category}")
    @RolesAllowed({USER, ADMIN})
    @Produces(MediaType.APPLICATION_JSON)
    public List<Meal> getByCategory(@PathParam("category") Categories category) {
        logger.info("Get meals for country - " + category.toString());
        return mealService.getByCategory(category);
    }

    @GET
    @Path("/search={query}")
    @RolesAllowed({USER, ADMIN})
    @Produces(MediaType.APPLICATION_JSON)
    public List<Meal> getByName(@PathParam("query") String query) {
        logger.info("Search for meals for string  -  " + query);
        return mealService.getByStringQuery(query);
    }
}
