package jpa;

import hibernate.chapter4.domain.Guide;
import hibernate.chapter4.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EagerRetrieveOfGuideObject {

    public static void main(String[] args) {
        EntityManager entityManager = PersistenceUtil.createEntityManagerFactory("hello").createEntityManager();
        EntityTransaction transaction =  entityManager.getTransaction();

        transaction.begin();

        Guide guide = entityManager.find(Guide.class, 1);

        transaction.commit();

        entityManager.close();

        printGuide(guide);
    }

    private static void printGuide(Guide guide) {
        for(Student student :guide.getStudents()) {
            System.out.println(student);
        }
    }
}
