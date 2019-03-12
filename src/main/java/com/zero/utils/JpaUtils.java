package com.zero.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
    private static EntityManagerFactory entityManagerFactory;
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("MyJpa");
    }
    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }
}
