package hibernate.chapter4.domain;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name ="city", column=@Column(name="homecity")),
            @AttributeOverride( name ="zipCode", column=@Column(name = "homezipcode")),
            @AttributeOverride( name ="street", column=@Column(name = "homestreet")),
    })
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name ="city", column=@Column(name = "workcity")),
            @AttributeOverride( name ="zipCode", column=@Column(name = "workZipCode")),
            @AttributeOverride( name ="street", column=@Column(name = "workstreet")),

    })
    private Address workAddress;

    public Person(){}

    public long getId() {
        return id;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Override
    public String toString() {
        return "[" +lastName +",\n" +
                firstName + ",\n" +
                workAddress + ",\n" +
                homeAddress + ",\n" + "]\n";
    }
}
