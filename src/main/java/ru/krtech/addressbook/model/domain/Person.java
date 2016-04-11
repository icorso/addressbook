package ru.krtech.addressbook.model.domain;

/**
 * Created by m.filippov on 08.04.16
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    public String getSurname() {
        return surname;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private String name;
    private String surname;

    protected Person() {}

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s', surname='%s']",
                id, name, surname);
    }

}
