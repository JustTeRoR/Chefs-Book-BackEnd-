package com.justterror.chefsbook.meal.boundary;

import com.justterror.chefsbook.meal.entity.Meal;

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

    @PersistenceContext(name="Meals")
    private EntityManager entityManager;

    public Meal getById(long id)
    {
        logger.info("Get message by id" + id);
        return entityManager.find(Meal.class, id);
    }

    public List<Meal> getAll()
    {
        TypedQuery<Meal> query = entityManager.createQuery("select m from Meal m", Meal.class);
        return query.getResultList();
    }
}
