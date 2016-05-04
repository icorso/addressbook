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
                "WHERE person.lastName LIKE :keyword OR person.phone LIKE :keyword");
        query.setParameter("keyword", "%" + keyword + "%");
        return query.getResultList();
    }

}
