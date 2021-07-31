package com.anime.watcher.repository;

import com.anime.watcher.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author sei3
 * on 31/07/2021.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
