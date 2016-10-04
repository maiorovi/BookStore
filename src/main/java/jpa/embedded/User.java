package jpa.embedded;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Address homeAddress;

    @AttributeOverrides({
            @AttributeOverride(name = "city.cityName", column = @Column(name = "work_city")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "work_zipcode")),
            @AttributeOverride(name = "phone", column = @Column(name = "work_phone"))
    })
    private Address workAddress;

    public User() {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }
}
