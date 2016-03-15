package hibernate.clients;

import hibernate.entities.Message;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MessagesClient {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Message message = new Message("Hibernate with xml mapping configuration");
        session.save(message);

        session.getTransaction().commit();
        session.close();
    }

}
