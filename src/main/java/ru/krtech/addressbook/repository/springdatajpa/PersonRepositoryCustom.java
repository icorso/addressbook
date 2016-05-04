package ru.krtech.addressbook.repository.springdatajpa;

import ru.krtech.addressbook.model.Person;

import java.util.List;

/**
 * Created by m.filippov on 04.05.16
 */
public interface PersonRepositoryCustom {

    public List<Person> getPersonsByKeyword(String keyword);
}
