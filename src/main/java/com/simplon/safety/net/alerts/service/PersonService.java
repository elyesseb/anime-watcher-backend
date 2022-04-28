package com.simplon.safety.net.alerts.service;

import com.simplon.safety.net.alerts.model.Person;
import com.simplon.safety.net.alerts.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ufhopla
 * on 27/04/2022.
 */

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonService(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Iterable<Person> list() {
        return personRepository.findAll();
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Iterable<Person> save(List<Person> persons) {
        return personRepository.saveAll(persons);
    }

}
