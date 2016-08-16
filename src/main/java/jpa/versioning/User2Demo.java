package jpa.versioning;

import jpa.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class User2Demo {

    public static void main(String[] args) {
        EntityManagerFactory factory = PersistenceUtil.createEntityManagerFactory("hello");

        EntityManager em = factory.createEntityManager();

        Teacher teacher = loadTeacher(em, 1);

        em.close();

        teacher.setSalary(5000);

        EntityManager em1 = factory.createEntityManager();

        updateTeacherAndPersist(em1, teacher);

        em1.close();
    }


    public static Teacher loadTeacher(EntityManager em, long id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Teacher teacher = em.find(Teacher.class, id);

        transaction.commit();

        return teacher;
    }

    public static void updateTeacherAndPersist(EntityManager em, Teacher teacher) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.merge(teacher);

        transaction.commit();
    }
}
