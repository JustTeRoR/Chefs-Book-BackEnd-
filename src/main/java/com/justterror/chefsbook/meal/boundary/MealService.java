package com.justterror.chefsbook.meal.boundary;

import com.justterror.chefsbook.meal.entity.Meal;
import com.justterror.chefsbook.utils.Categories;
import com.justterror.chefsbook.utils.Countries;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class MealService {

    @Inject
    Logger logger;

    @PersistenceContext(name="meals")
    private EntityManager entityManager;

    public Meal getById(long id)
    {
        String rawQuery = "select m from Meal m where id = " + id;
        TypedQuery<Meal> query = entityManager.createQuery(rawQuery, Meal.class);
        return query.getSingleResult();
    }

    public List<Meal> getAll()
    {
        //jpql
        TypedQuery<Meal> query = entityManager.createQuery("select m from Meal m", Meal.class);
        return query.getResultList();
    }

    public List<Meal> getByCountry(Countries country) {
        String russianRepresentance = country.toString();
        String rawQuery = "select m from Meal m where country = \'" + russianRepresentance + "\'";
        TypedQuery<Meal> query = entityManager.createQuery(rawQuery, Meal.class);
        return query.getResultList();
    }

    public List<Meal> getByCategory(Categories categories) {
        String russianRepresentance = categories.toString();
        String rawQuery = "select m from Meal m where category = \'" + russianRepresentance + "\'";
        TypedQuery<Meal> query = entityManager.createQuery(rawQuery, Meal.class);
        return query.getResultList();
    }

    public List<Meal> getByStringQuery(String query) {
        String rawQuery = "select m from Meal m where name LIKE \'%" + query + "%\'";
        TypedQuery<Meal> typedQuery= entityManager.createQuery(rawQuery, Meal.class);
        return typedQuery.getResultList();
    }
}
