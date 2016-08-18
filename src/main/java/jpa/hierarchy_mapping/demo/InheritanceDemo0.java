package jpa.hierarchy_mapping.demo;

import jpa.PersistenceUtil;
import jpa.hierarchy_mapping.Cat;
import jpa.hierarchy_mapping.Dog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class InheritanceDemo0 {
    public static void main(String[] args) {
        EntityManagerFactory factory = PersistenceUtil.createEntityManagerFactory("hello");

        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        
        Cat cat = new Cat("Kitty");
        Dog dog = new Dog("Rex");

        em.persist(cat);
        em.persist(dog);

        em.getTransaction().commit();

        em.close();
    }
}
