package ru.krtech.addressbook.repository;

import org.springframework.data.repository.CrudRepository;
import ru.krtech.addressbook.model.Address;

/**
 * Created by m.filippov on 08.04.16
 */
public interface AddressRepository extends CrudRepository<Address, Long> {
}
