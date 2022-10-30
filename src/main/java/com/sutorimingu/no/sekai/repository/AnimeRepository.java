package com.sutorimingu.no.sekai.repository;

import com.sutorimingu.no.sekai.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {
    // Maintenant nous pouvons utiliser les méthodes de JpaRepository sans implémenter les méthodes
    List<Anime> findByTitleLike(String title);
    // Méthode de recherche personnalisées
    // SELECT * FROM anime
    // WHERE title
    // LIKE '%title%'
    // '%title%' pour rechercher tous les enregistrement qui utilisent le caractère “title”.
}
