package ru.krtech.addressbook.model.domain;

/**
 * Created by m.filippov on 12.04.16
 */
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @NotNull
    private String city;

    @NotNull
    private String region;

    @NotNull
    private String street;

    @NotNull
    private String house;

    private String flat;


    protected Address() {}

    public Address(Address a) {
        this.id = a.id;
        this.city = a.city;
        this.region = a.region;
        this.street = a.street;
        this.house = a.house;
        this.flat = a.flat;
    }

    @Override
    public String toString() {
        return String.format(
                "Address[id=%d, city='%s', street='%s']",
                id, city, street);
    }

}
