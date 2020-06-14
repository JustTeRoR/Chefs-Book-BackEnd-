package com.justterror.chefsbook.category.boundary;

import com.justterror.chefsbook.category.entity.Category;
import com.justterror.chefsbook.meal.entity.Meal;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CategoryService {
    @Inject
    Logger logger;

    @PersistenceContext(name="categories")
    private EntityManager entityManager;

    public List<Category> getAll()
    {
        //jpql
        TypedQuery<Category> query = entityManager.createQuery("select c from Category c", Category.class);
        return query.getResultList();
    }
}
