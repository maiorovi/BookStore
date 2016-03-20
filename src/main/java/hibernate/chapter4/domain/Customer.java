package hibernate.chapter4.domain;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private int id;
    @Column(name = "name")
    private String name;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumns({
            @JoinColumn(name = "passport_series"),
            @JoinColumn(name = "passport_number")
    })
    private Passport passport;

    public Customer() {}

    public Customer(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
