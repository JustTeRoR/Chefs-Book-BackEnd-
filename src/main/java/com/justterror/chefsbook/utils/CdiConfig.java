package com.justterror.chefsbook.utils;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CdiConfig {

    @Produces
    @Dependent
    @PersistenceContext(unitName = "Meals")
    public EntityManager entityManager;

}