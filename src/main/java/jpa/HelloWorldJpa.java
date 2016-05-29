package jpa;

import hibernate.entities.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class HelloWorldJpa {
    public static void main(String[] args) {
        Message msg = new Message("Hello World of JPA"); // transient state

        EntityManagerFactory factory = PersistenceUtil.createEntityManagerFactory("hello");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            entityManager.persist(msg); // persisted state

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) transaction.rollback();
            ex.printStackTrace();
        } finally {
            if (entityManager != null) entityManager.close(); // after close entity becomes detached
        }

    }
}
