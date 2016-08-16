package jpa.merging;

import hibernate.chapter4.domain.Guide;
import hibernate.chapter4.domain.Student;
import jpa.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class MergingDemo {

    public static void main(String[] args) {
        EntityManagerFactory factory = PersistenceUtil.createEntityManagerFactory("hello");
        EntityManager em1 = factory.createEntityManager();

        EntityTransaction transaction = em1.getTransaction();
        transaction.begin();

        Guide guide = em1.find(Guide.class,  2);
        System.out.println("Loaded following guide: " + guide);

        transaction.commit();
        em1.close();

        guide.setSalary(2500);
        List<Student> students = new ArrayList<Student>(guide.getStudents());
        students.get(0).setName("Newbee");

        EntityManager em2 = factory.createEntityManager();
        EntityTransaction et =  em2.getTransaction();
        et.begin();

        em2.merge(guide);

        et.commit();
        em2.close();
    }
}
