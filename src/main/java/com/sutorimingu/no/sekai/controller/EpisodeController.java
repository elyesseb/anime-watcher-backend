package com.sutorimingu.no.sekai.controller;

import com.sutorimingu.no.sekai.dto.EpisodeDto;
import com.sutorimingu.no.sekai.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sei3
 * on 20/08/2021.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/episode")
public class EpisodeController {
    @Autowired
    private EpisodeRepository repository;

    @GetMapping("/list")
    List<EpisodeDto> listEpispodes(@RequestParam("anime_id") Long animeId) {
        return repository.findEpisodesByAnime_IdOrderBySeasonAscEpisodeNbAsc(animeId).stream()
                .map(EpisodeDto::new).collect(Collectors.toList());


    }
}
