package com.simplon.safety.net.alerts.controller;

import com.simplon.safety.net.alerts.model.Person;
import com.simplon.safety.net.alerts.repository.PersonRepository;
import com.simplon.safety.net.alerts.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ufhopla
 * on 27/04/2022.
 */

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/list")
    public Iterable<Person> list() {
        return personService.list();
    }

    @PostMapping("/add")
    Person newMedicalRecord(@RequestBody Person newPerson) {
        return personRepository.save(newPerson);
    }

}
