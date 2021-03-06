package jpa.derived_proerties;

import jpa.attribute_converters.MonetaryAmountConverter;
import jpa.converters_example.MonetaryAmount;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collections;

@Entity
@Table(name = "BID")
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Convert(
            converter = MonetaryAmountConverter.class,
            disableConversion = false
    )
    @Column(name="AMOUNT")
    private MonetaryAmount amount;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "product_id")
    private Product product;
    @Enumerated(EnumType.STRING)
    private BidType bidType;

    public Bid(){}

    public Bid(MonetaryAmount amount) {
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public MonetaryAmount getAmount() {
        return amount;
    }

    public void setAmount(MonetaryAmount amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BidType getBidType() {
        return bidType;
    }

    public void setBidType(BidType bidType) {
        this.bidType = bidType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bid bid = (Bid) o;

        if (id != bid.id) return false;
        if (amount != bid.amount) return false;
        return product.equals(bid.product);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + amount.getValue().intValue();
        result = 31 * result + product.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
