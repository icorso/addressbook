package ru.krtech.addressbook.repository.springdatajpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import ru.krtech.addressbook.model.Person;

import java.util.List;

/**
 * Created by m.filippov on 04.05.16
 */
@Repository
public class PersonRepositoryImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> getPersonsByKeyword(String keyword) {
        Query query = this.em.createQuery("SELECT DISTINCT person FROM Person person " +
                "LEFT JOIN FETCH person.address as address " +
                "WHERE person.firstName LIKE :keyword OR person.lastName LIKE :keyword OR person.phone LIKE :keyword " +
                "OR address.city LIKE :keyword OR address.region LIKE :keyword OR address.street LIKE :keyword");
        query.setParameter("keyword", "%" + keyword + "%");
        return query.getResultList();
    }

}
