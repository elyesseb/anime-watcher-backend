package com.simplon.safety.net.alerts.repository;

import com.simplon.safety.net.alerts.model.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ufhopla
 * on 27/04/2022.
 */
public interface PersonRepository extends CrudRepository<Person,Long> {
}
