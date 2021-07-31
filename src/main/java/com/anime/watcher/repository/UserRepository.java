package com.anime.watcher.repository;

import com.anime.watcher.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sei3
 * on 31/07/2021.
 */
@Service
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByUsername(String username);

    List<User> findByEmail(String email);

}
