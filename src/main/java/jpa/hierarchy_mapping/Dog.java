package jpa.hierarchy_mapping;

import javax.persistence.Entity;

@Entity
public class Dog extends Animal {

    public Dog(String name) {
        this.name = name;
    }

    public Dog() {
    }

    @Override
    public String makeNoise() {
        return "Woof";
    }
}
