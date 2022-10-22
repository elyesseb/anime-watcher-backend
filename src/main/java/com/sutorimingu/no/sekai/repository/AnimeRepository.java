package com.sutorimingu.no.sekai.repository;

import com.sutorimingu.no.sekai.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sei3
 * on 31/07/2021.
 */
@Service
public interface AnimeRepository extends JpaRepository<Anime, Long> {
    // Maintenant nous pouvons utiliser les méthodes de JpaRepository sans implémenter les méthodes
    List<Anime> findByTitleLike(String title);
    // Méthode de recherche personnalisées
    // SELECT * FROM anime
    // WHERE title
    // LIKE '%title%'
    // '%title%' pour rechercher tous les enregistrement qui utilisent le caractère “title”.
}
