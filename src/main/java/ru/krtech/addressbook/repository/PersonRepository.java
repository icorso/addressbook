package ru.krtech.addressbook.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import ru.krtech.addressbook.model.Person;
import ru.krtech.addressbook.repository.springdatajpa.PersonRepositoryCustom;

import java.util.List;

/**
 * Created by m.filippov on 08.04.16
 */
public interface PersonRepository extends CrudRepository<Person, Long>, PersonRepositoryCustom {

    public List<Person> getPersonsByKeyword(String keyword) throws DataAccessException;

}
