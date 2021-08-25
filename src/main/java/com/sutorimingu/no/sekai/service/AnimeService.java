package com.sutorimingu.no.sekai.service;

import com.sutorimingu.no.sekai.model.Anime;
import com.sutorimingu.no.sekai.model.FileDB;
import com.sutorimingu.no.sekai.repository.AnimeRepository;
import com.sutorimingu.no.sekai.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

/**
 * @author sei3
 * on 20/08/2021.
 */
@Service
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    @Autowired
    private FileStorageService storageService;

    @Autowired
    private EpisodeRepository episodeRepository;

    public void addPictureToAnime(final MultipartFile file, final Long animeId) throws IOException {
        final Optional<Anime> animeOpt = animeRepository.findById(animeId);

        if(animeOpt.isPresent()){
            final Anime anime = animeOpt.get();
            final FileDB store = storageService.store(file);

            anime.setFileDB(store);
            animeRepository.save(anime);
        }
        else{
            //TODO: ANIME NOT FOUND
        }
    }



//    public void addEpisodeToAnime(final Episode episode, final Long animeId) throws IOException {
//        final Optional<Anime> animeOpt = animeRepository.findById(animeId);
//
//        if(animeOpt.isPresent()){
//            final Anime anime = animeOpt.get();
//            final EpisodeDto episodeDto = episo.store(episode);
//
//            anime.setFileDB(episodeDto);
//            animeRepository.save(anime);
//        }
//        else{
//            //TODO: ANIME NOT FOUND
//        }
//    }



}
