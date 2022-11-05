package com.sutorimingu.no.sekai.repository;

import com.sutorimingu.no.sekai.model.Anime;
import com.sutorimingu.no.sekai.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {
    List<Episode> findEpisodesByAnime_IdOrderBySeasonAscEpisodeNbAsc(Long Anime_id);
    List<Episode> findAllByAnime(Anime anime);
}
