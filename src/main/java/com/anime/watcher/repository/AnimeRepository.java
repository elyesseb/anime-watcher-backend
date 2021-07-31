package com.anime.watcher.repository;

import com.anime.watcher.model.Anime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * @author sei3
 * on 31/07/2021.
 */
@Service
public interface AnimeRepository extends CrudRepository<Anime, Long> {
}
