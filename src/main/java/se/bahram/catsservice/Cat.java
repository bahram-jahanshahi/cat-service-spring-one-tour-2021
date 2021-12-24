package se.bahram.catsservice;

import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String name;

    Cat() {
    }

    public Cat(String name) {
        Assert.isTrue(Character.isUpperCase(name.charAt(0)), () -> "the first character of the name must be uppercase");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
