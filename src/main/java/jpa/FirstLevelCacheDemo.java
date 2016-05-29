package jpa;

import jpa.entities.Alert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class FirstLevelCacheDemo {
    public static void main(String[] args) {
        oneEntityManagerTwoQueries();
        System.out.println("\n ============================== \n");
        twoEntityManagersTwoQueries();
    }

    private static void oneEntityManagerTwoQueries() {
        EntityManagerFactory entityManagerFactory = PersistenceUtil.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Alert alert = entityManager.find(Alert.class, 6);
        System.out.println("retrieved message is:" + alert);

        Alert alert1 = entityManager.find(Alert.class, 6);
        System.out.println("retrieved message is:" + alert1);

        transaction.commit();
        entityManager.close();
    }

    private static void twoEntityManagersTwoQueries() {
        EntityManagerFactory entityManagerFactory = PersistenceUtil.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Alert alert = entityManager.find(Alert.class, 6);
        System.out.println("retrieved message is:" + alert);

        transaction.commit();
        entityManager.close();

        EntityManager entityManager1 = entityManagerFactory.createEntityManager();

        EntityTransaction transaction1 = entityManager1.getTransaction();

        transaction1.begin();

        Alert alert1 = entityManager1.find(Alert.class, 6);
        System.out.println("retrieved message is:" + alert1);

        transaction1.commit();
        entityManager1.close();
    }
}
