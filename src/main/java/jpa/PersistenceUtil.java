package jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {

    public static EntityManagerFactory createEntityManagerFactory(String profile) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(profile);

        return factory;
    }
}
