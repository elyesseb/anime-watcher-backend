package com.sutorimingu.no.sekai.controller;

import com.sutorimingu.no.sekai.dto.EpisodeDto;
import com.sutorimingu.no.sekai.exceptions.AnimeNotFoundException;
import com.sutorimingu.no.sekai.model.Episode;
import com.sutorimingu.no.sekai.repository.AnimeRepository;
import com.sutorimingu.no.sekai.repository.EpisodeRepository;
import com.sutorimingu.no.sekai.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sei3
 * on 20/08/2021.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path="/episode")
public class EpisodeController {
    @Autowired
    private EpisodeRepository episodeRepository;
    @Autowired
    private AnimeRepository animeRepository;
    @Autowired
    private AnimeService animeService;

    @GetMapping("/list")
    List<EpisodeDto> listEpispodes(@RequestParam("anime_id") Long animeId) {
        return episodeRepository.findEpisodesByAnime_IdOrderBySeasonAscEpisodeNbAsc(animeId).stream()
                .map(EpisodeDto::new).collect(Collectors.toList());
    }

    @GetMapping("/list/{id}")
    Episode getEpisodesById(@PathVariable Long id) {
        return episodeRepository.findById(id)
                .orElseThrow(() -> new AnimeNotFoundException(id));
    }

    @PostMapping("/add")
    Episode addEpisode(@RequestParam("anime_id") Long animeId, @RequestBody Episode newEpisode) {
        newEpisode.setAnime(animeRepository.getReferenceById(animeId));
        return episodeRepository.save(newEpisode);
    }

    @DeleteMapping("/list/{id}")
    public ResponseEntity<HttpStatus> deleteEpisode(@PathVariable("id") long id) {
        try {
            episodeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
