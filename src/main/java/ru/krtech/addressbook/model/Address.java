package ru.krtech.addressbook.model;

/**
 * Created by m.filippov on 12.04.16
 */
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="address")
public class Address {

    private long id;

    @NotNull
    @Size(min=2, max=30)
    private String city;

    @NotNull
    @Size(min=2, max=30)
    private String region;

    @NotNull
    @Size(min=2, max=30)
    private String street;

    @Size(max=5)
    private String house;

    @Size(max=5)
    private String flat;

    private Person person;

    public Address(){}

    public Address(Address a) {
        this.id = a.id;
        this.city = a.city;
        this.region = a.region;
        this.street = a.street;
        this.house = a.house;
        this.flat = a.flat;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @OneToOne(mappedBy = "address")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return String.format(
                "Address[id=%d, city='%s', region='%s']",
                id, city, region);
    }

}
