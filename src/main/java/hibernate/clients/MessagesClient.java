package hibernate.clients;

import hibernate.entities.Message;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MessagesClient {

    public static void main(String[] args) {
//        System.setProperty("log4j.configurationFile", "log4j.properties");

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        Message message = new Message("JBOSS Logging Library with Log4j in Action, 2r");
//        session.save(message);\
        Message message = session.get(Message.class, 7);
//        message.setMessage("Dirty ");
        session.delete(message);

        session.getTransaction().commit();
        session.close();
    }

}
