package com.sutorimingu.no.sekai.service;

import com.sutorimingu.no.sekai.model.Anime;
import com.sutorimingu.no.sekai.model.FileDB;
import com.sutorimingu.no.sekai.repository.AnimeRepository;
import com.sutorimingu.no.sekai.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            new ResponseEntity<>(animeRepository.save(anime), HttpStatus.OK);
        }
        else{
            new ResponseEntity<Anime>(HttpStatus.NOT_FOUND);
        }
    }

    public List<Anime> getAllAnimes(Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        Page<Anime> pagedResult = animeRepository.findAll(paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Anime>();
        }
    }

}
