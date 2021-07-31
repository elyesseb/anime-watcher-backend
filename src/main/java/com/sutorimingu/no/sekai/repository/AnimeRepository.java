package com.sutorimingu.no.sekai.repository;

import com.sutorimingu.no.sekai.model.Anime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sei3
 * on 31/07/2021.
 */
@Service
public interface AnimeRepository extends CrudRepository<Anime, Long> {

    List<Anime> findByTitleLike(String title);

}
