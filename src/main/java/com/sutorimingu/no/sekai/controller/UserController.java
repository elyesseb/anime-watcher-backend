package com.sutorimingu.no.sekai.controller;

import com.sutorimingu.no.sekai.exceptions.UserNotFoundException;
import com.sutorimingu.no.sekai.model.User;
import com.sutorimingu.no.sekai.repository.UserRepository;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sei3
 * on 31/07/2021.
 */
@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository repository;



    @GetMapping("/list")
    List<User> all() {
        return IterableUtils.toList(repository.findAll());
    }

    @PostMapping("/add")
    User newUser(@RequestBody User newUser) {
        newUser.setIs_admin(false);
        return repository.save(newUser);
    }

    @PostMapping("/addAdmin")
    User newAdmin(@RequestBody User newUser) {
        newUser.setIs_admin(true);
        return repository.save(newUser);
    }

    @GetMapping("/getUserbyId/{id}")
    User getUserById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @GetMapping("/getUserbyUsername/{username}")
    User getUserByName(@PathVariable String username) {
        final List<User> users = repository.findByUsername(username);
        if(users.isEmpty()){
            throw new UserNotFoundException(username);
        }
        return users.get(0);
    }
}