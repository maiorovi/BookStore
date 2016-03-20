package hibernate.chapter4.client;

import hibernate.chapter4.domain.Address;
import hibernate.chapter4.domain.Guide;
import hibernate.chapter4.domain.Person;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PersonClient {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Guide guide = new Guide("0", 4000, "Alexei");
        Person person = new Person();
        person.setFirstName("Egor");
        person.setLastName("Maiorov");
        person.setHomeAddress(new Address("Kiev", "Mashinobudivna","01013"));
        person.setWorkAddress(new Address("Kiev", "Radisheva st", "01013"));

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(person);

//        person = session.get(Person.class, 1l);
//        System.out.println(person.toString());



        session.getTransaction().commit();
        session.close();
    }

}
