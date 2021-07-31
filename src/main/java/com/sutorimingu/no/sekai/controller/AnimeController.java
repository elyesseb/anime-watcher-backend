package com.sutorimingu.no.sekai.controller;

import com.sutorimingu.no.sekai.exceptions.AnimeNotFoundException;
import com.sutorimingu.no.sekai.model.Anime;
import com.sutorimingu.no.sekai.repository.AnimeRepository;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sei3
 * on 31/07/2021.
 */
@RestController
@RequestMapping(path="/anime")
public class AnimeController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private AnimeRepository repository;



    @GetMapping("/list")
    List<Anime> all() {
        return IterableUtils.toList(repository.findAll());
    }

    @PostMapping("/add")
    Anime newUser(@RequestBody Anime newAnime) {
        return repository.save(newAnime);
    }


    @GetMapping("/getAnimeById/{id}")
    Anime getAnimeById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new AnimeNotFoundException(id));
    }

    @GetMapping("/getAnimeByTitle/{title}")
    List<Anime> getAnimeByTitle(@PathVariable String title) {
        return repository.findByTitleLike("%"+title+"%");
    }

}