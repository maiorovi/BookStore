package jpa;

import jpa.entities.Alert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class JpaEntityStateTest {

    public static void main(String[] args) {

        Alert alert = new Alert("Try2!");
        EntityManagerFactory entityManagerFactory = PersistenceUtil.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(alert);

        transaction.commit();
        entityManager.close();

        alert.setMsg("Try3!");
        EntityManager em = PersistenceUtil.createEntityManagerFactory("hello").createEntityManager();
        EntityTransaction transaction0 = em.getTransaction();
        transaction0.begin();

        em.merge(alert);

        transaction0.commit();
        em.close();
    }
}
