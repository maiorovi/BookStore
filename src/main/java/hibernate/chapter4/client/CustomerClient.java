package hibernate.chapter4.client;

import hibernate.chapter4.domain.Customer;
import hibernate.chapter4.domain.Passport;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CustomerClient {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Passport passport = new Passport("AK", "12345");

        Customer customer = new Customer("JVM", passport);

        passport.setCustomer(customer);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(customer);

        session.getTransaction().commit();
    }

}
