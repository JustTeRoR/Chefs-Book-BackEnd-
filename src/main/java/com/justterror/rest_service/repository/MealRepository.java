package com.justterror.rest_service.repository;

import com.justterror.rest_service.entity.Meal;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class MealRepository {

    @Inject
    Logger logger;

    @Inject
    private EntityManager entityManager;

    public Meal getById(long id)
    {
        logger.info("Get message by id" + id);
        return entityManager.find(Meal.class, id);
    }

    public List<Meal> getAll()
    {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Meal> criteriaQuery = criteriaBuilder.createQuery(Meal.class);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
