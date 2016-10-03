package jpa.derived_proerties;

import jpa.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.HashSet;

public class FormulaAnnotationDemo {

    public static void main(String[] args) {
        EntityManagerFactory factory = PersistenceUtil.createEntityManagerFactory("hello");

        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

      Product product = new Product("Washing powder", 250);
      Bid bid1 = new Bid(50);
        bid1.setBidType(BidType.AVERAGE_BID);
        bid1.setProduct(product);
      Bid bid2 = new Bid(100);
        bid2.setBidType(BidType.HIGHEST_BID);
        bid2.setProduct(product);

      HashSet<Bid> col = new HashSet<>();
      col.add(bid1);
      col.add(bid2);

      product.setBid(col);

      entityManager.persist(product);
//      let`s try to load product from db
//        Product product = entityManager.find(Product.class, 1l);

        System.out.println(product.toString());
        System.out.println(product.getAverageBid());

        transaction.commit();

        entityManager.close();
    }

}
