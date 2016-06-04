package jpa;

import hibernate.chapter4.domain.Guide;
import hibernate.chapter4.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JpqlIntro {

    public static void main(String[] args) {
        //lets try to fetch student using jpql
        EntityManager entityManager =  PersistenceUtil.createEntityManagerFactory("hello").createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query query = entityManager.createQuery("select guide from Student as guide");
        List<Student> students = query.getResultList();
        for (Student student: students) {
            System.out.println(student);
        }

        transaction.commit();

        entityManager.close();

    }
}
