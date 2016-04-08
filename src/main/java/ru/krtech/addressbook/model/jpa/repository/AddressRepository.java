package ru.krtech.addressbook.model.jpa.repository;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.CrudRepository;
import ru.krtech.addressbook.model.jpa.entity.Person;

/**
 * Created by m.filippov on 08.04.16
 */
public interface AddressRepository extends CrudRepository<Person, Long> {
}
