package jpa;

import hibernate.chapter4.domain.Guide;
import hibernate.chapter4.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Parameter;
import javax.persistence.Query;
import java.util.List;

public class JpqlPratice {

    public static void main(String[] args) {
        EntityManager em = PersistenceUtil.createEntityManagerFactory("hello").createEntityManager();
        EntityTransaction transaction =  em.getTransaction();

        transaction.begin();

        //this query is valid for getting all sutdents with out guide
        Query query = em.createQuery("select student.name, student.enrollmentId from Student as student where student.guide = null");

   /*     List<Object[]> resultList = query.getResultList();

        for (Object[] objects : resultList) {
            System.out.println("Object[] {name: " + objects[0] + ", enrollmentId: " + objects[1] + "}");
        }
*/

        Query query1 = em.createQuery("select guide from Guide guide left join guide.students r where r.guide = null");
        List<Guide> guides = query1.getResultList();

        for (Guide guide : guides) {
            System.out.println(guide);
        }

        transaction.commit();
    }
}
