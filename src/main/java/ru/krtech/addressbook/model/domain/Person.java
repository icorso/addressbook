package ru.krtech.addressbook.model.domain;

/**
 * Created by m.filippov on 08.04.16
 */
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    private String patronimic;

    private String phone;

    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)" +
            "*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message="{invalid.email}")
    private String email;

    private Date birthday;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    protected Person() {}

    public Person(Person p) {
        this.id = p.id;
        this.name = p.name;
        this.surname = p.surname;
        this.phone = p.phone;
        this.email = p.email;
    }

    @Override
    public String toString() {
        return String.format(
                "Person[id=%d, name='%s', surname='%s']",
                id, name, surname);
    }

}
