package jpa.hierarchy_mapping;

import javax.persistence.Entity;

@Entity
public class Cat extends Animal {

    public Cat(String name) {
        this.name = name;
    }

    public Cat() {
    }

    @Override
    public String makeNoise() {
        return "Meow";
    }
}
