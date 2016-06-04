package jpa;

import hibernate.chapter4.domain.Guide;
import hibernate.chapter4.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EagerRetrieveOfStudentObject {

    public static void main(String[] args) {
        EntityManager entityManager = PersistenceUtil.createEntityManagerFactory("hello").createEntityManager();
        EntityTransaction transaction =  entityManager.getTransaction();

        transaction.begin();

        Student student = entityManager.find(Student.class, 1);

        transaction.commit();

        entityManager.close();

        System.out.println(student.getGuide());
    }
}
