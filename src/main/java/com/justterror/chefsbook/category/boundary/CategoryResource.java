package com.justterror.chefsbook.category.boundary;

import com.justterror.chefsbook.category.entity.Category;
import com.justterror.chefsbook.meal.boundary.MealService;
import com.justterror.chefsbook.meal.entity.Meal;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

import static com.justterror.chefsbook.security.Constants.ADMIN;
import static com.justterror.chefsbook.security.Constants.USER;

@ApplicationScoped
@Path("/category")
public class CategoryResource {

    @Inject
    Logger logger;

    @Inject
    private SecurityContext securityContext;

    @Inject
    private CategoryService categoryService;

    @GET
    @Path("/")
    @RolesAllowed({USER, ADMIN})
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> list()
    {
        logger.info("Get all categories");
        return categoryService.getAll();
    }
}
