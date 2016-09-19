package jpa.derived_proerties;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="NAME")
    private String name;
    @Column(name = "PRICE")
    private int price;
    @Formula("PRICE/26")
    private int priceInUsd;
    @OneToMany(mappedBy = "product")
    @Cascade( value = CascadeType.ALL)
    private Set<Bid> bid;
    @Formula("(select avg(b.amount) from BID b where b.product_id=id)")
    private int averageBid;

    public Product() {
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
        this.priceInUsd = priceInUsd;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPriceInUsd() {
        return priceInUsd;
    }

    public Set<Bid> getBid() {
        return bid;
    }

    public void setBid(Set<Bid> bid) {
        this.bid = bid;
    }

    public int getAverageBid() {
        return averageBid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", priceInUsd=" + priceInUsd +
                ", bid=" + bid +
                ", averageBid=" + averageBid +
                '}';
    }
}
