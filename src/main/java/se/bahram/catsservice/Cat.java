package se.bahram.catsservice;

import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String name;

    public LocalDate dateOfBirth;

    Cat() {
    }

    public Cat(String name) {
        Assert.isTrue(Character.isUpperCase(name.charAt(0)), () -> "the first character of the name must be uppercase");
        this.name = name;
    }

    public Cat(String name, LocalDate dataOfBirth) {
        this(name);
        this.dateOfBirth = dataOfBirth;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getAgeInMonths() {
        if (dateOfBirth == null) {
            return null;
        }
        return Period.between(this.dateOfBirth, LocalDate.now()).getMonths();
    }
}
