package com.require4testing.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Require4TestingPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
