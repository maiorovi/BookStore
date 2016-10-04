package jpa.embedded;

import jpa.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

public class EmbeddedDemo {

    public static void main(String[] args) {
        EntityManagerFactory factory = PersistenceUtil.createEntityManagerFactory("hello");

        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        User user = createUser();

        em.persist(user);

        transaction.commit();
        em.close();
    }

    public static User createUser() {
        User user = new User();


        Address homeAddress = new Address();
        homeAddress.setCity(new City("New-York"));
        homeAddress.setPhone("050 321-76-74");
        homeAddress.setZipCode("01013");

        Address workAddress = new Address();
        workAddress.setCity(new City("Kiev"));
        workAddress.setPhone("044 432-65-34");
        workAddress.setZipCode("03073");

        user.setHomeAddress(homeAddress);
        user.setWorkAddress(workAddress);
        user.setName("Karl Welch");

        return user;
    }

}
