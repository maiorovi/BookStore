package jpa.hierarchy_mapping.demo;

import jpa.PersistenceUtil;
import jpa.hierarchy_mapping.Animal;
import jpa.hierarchy_mapping.Cat;
import jpa.hierarchy_mapping.Dog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class InheritanceFetchingDemo {
    public static void main(String[] args) {
        EntityManagerFactory factory = PersistenceUtil.createEntityManagerFactory("hello");

        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("select dog from Dog dog");
        Query queryCat = em.createQuery("select cat from Cat cat");
        Query queryAnimal = em.createQuery("select animal from Animal animal");
        List<Dog> dogs = query.getResultList();
        List<Animal> animals = queryAnimal.getResultList();
        List<Cat> cats = queryCat.getResultList();

        for (Cat cat: cats) {
            System.out.println(cat);
        }

        em.getTransaction().commit();
    }
}
