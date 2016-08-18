package jpa;

import hibernate.chapter4.domain.Guide;
import hibernate.chapter4.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class JustPersistOneStudent {

    public static void main(String[] args) {
        Guide guide0 = new Guide("2000", 1000, "Mike Lawson");
        Guide guide1 = new Guide("2001", 2000, "Ian Lamb");

        EntityManager em  = PersistenceUtil.createEntityManagerFactory("hello").createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();

        Student bruceLee = new Student("Bruce Lee","e031567");
        Student amy = new Student("Amy Jade Gill", "e031568");
        amy.setGuide(guide1);
        Student john = new Student("John Smith", "e031569");
        john.setGuide(guide1);
//
        em.persist(amy);
        em.persist(john);
        em.persist(bruceLee);
        em.persist(guide0);

        et.commit();

        em.close();
    }

}
