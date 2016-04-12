package ru.krtech.addressbook.model.repository;

import org.springframework.data.repository.CrudRepository;
import ru.krtech.addressbook.model.domain.Address;
import ru.krtech.addressbook.model.domain.Person;

/**
 * Created by m.filippov on 08.04.16
 */
public interface AddressRepository extends CrudRepository<Address, Long> {
}
