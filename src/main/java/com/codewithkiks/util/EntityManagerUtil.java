package com.codewithkiks.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
    private static EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("persistence-unit");
    private static EntityManager em;

    public static EntityManager getEntityManager() {
        if (em == null) {
            em = emf.createEntityManager();
        }
        return em;
    }
}
