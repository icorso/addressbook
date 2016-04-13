package ru.krtech.addressbook.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.krtech.addressbook.model.domain.Person;

import java.util.List;

/**
 * Created by m.filippov on 08.04.16
 */
public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findByPhone(String phone);

}
