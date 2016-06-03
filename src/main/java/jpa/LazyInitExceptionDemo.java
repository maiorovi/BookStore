package jpa;

import hibernate.chapter4.domain.Guide;
import hibernate.chapter4.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class LazyInitExceptionDemo {

    public static void main(String[] args) {
        Guide guide0 = new Guide("01", 4000, "Robert");

        Student student0 = createStudent("01", guide0, "Egor");
        Student student1 = createStudent("02", guide0, "Ivan");

        guide0.addStudent(student0);
        guide0.addStudent(student1);

        EntityManagerFactory factory = PersistenceUtil.createEntityManagerFactory("hello");

        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction  transaction = entityManager.getTransaction();
        transaction.begin();

//        entityManager.persist(student0);
        Guide guide = entityManager.find(Guide.class, 1);
        //here it works well because of lazy collection fetching
//        printGuide(guide);
        transaction.commit();

        entityManager.close();

        // while if we try to load student here we will get lazy init exception
        printGuide(guide);
    }

    private static void printGuide(Guide guide) {
        for(Student student :guide.getStudents()) {
            System.out.println(student);
        }
    }

    private static Student createStudent(String enrollmentId, Guide guide, String name) {
        Student student = new Student();
        student.setEnrollmentId(enrollmentId);
        student.setGuide(guide);
        student.setName(name);

        return student;
    }

}
