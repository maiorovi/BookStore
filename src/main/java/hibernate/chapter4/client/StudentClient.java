package hibernate.chapter4.client;

import hibernate.chapter4.domain.Guide;
import hibernate.chapter4.domain.Student;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.HashSet;

public class StudentClient {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Guide guide0 = new Guide("01", 4000, "Robert");
        Guide guide1 = new Guide("01", 3000, "William");

        Student student0 = createStudent("01", guide0, "Egor");
        Student student1 = createStudent("02", guide1, "Ivan");

        guide0.addStudent(student0);
        guide0.addStudent(student1);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(guide0);
//        session.persist(student0);
//        session.persist(student1);
//        student = session.get(Student.class, 1);
//        session.delete(student);


        session.getTransaction().commit();
        session.close();
    }

    private static Student createStudent(String enrollmentId, Guide guide, String name) {
        Student student = new Student();
        student.setEnrollmentId(enrollmentId);
        student.setGuide(guide);
        student.setName(name);

        return student;
    }

}
