package com.sutorimingu.no.sekai.repository;

import com.sutorimingu.no.sekai.model.Anime;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author ufhopla
 * on 21/10/2022.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
class AnimeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    AnimeRepository repository;

    public static Date parseDate(String date) {
        try {
            new SimpleDateFormat("yyyy-MM-dd").parse(date);
            return java.sql.Date.valueOf(date);
        } catch (ParseException e) {
            return null;
        }
    }

    @Test
    public void shouldFindNoAnimesIfRepositoryIsEmpty() {
        Iterable animes = repository.findAll();
        assertThat(animes).isEmpty();
    }

    @Test
    public void shouldStoreAnime() {

        Anime anime = new Anime();
        anime.setTitle("Naruto");
        anime.setGenre("Action");
        anime.setSynopsis("Naruto is ninja from konoha");
        anime.setAired((java.sql.Date) parseDate("2014-02-14"));
        anime.setEnded((java.sql.Date) parseDate("2014-02-14"));
        anime.setRating(4.6f);

        Anime animeSaved = repository.save(anime);

        assertThat(anime).hasFieldOrPropertyWithValue("title", "Naruto");
        assertThat(anime).hasFieldOrPropertyWithValue("genre", "Action");
        assertThat(anime).hasFieldOrPropertyWithValue("synopsis", "Naruto is ninja from konoha");
        assertThat(anime).hasFieldOrPropertyWithValue("aired", (java.sql.Date) parseDate("2014-02-14"));
        assertThat(anime).hasFieldOrPropertyWithValue("ended", (java.sql.Date) parseDate("2014-02-14"));
        assertThat(anime).hasFieldOrPropertyWithValue("rating", 4.6f);

    }

    @Test
    public void shouldFindAllAnimes() {
        Anime anime1 = new Anime();
        anime1.setTitle("Naruto");
        anime1.setGenre("Action");
        anime1.setSynopsis("Naruto is ninja from konoha");
        anime1.setAired((java.sql.Date) parseDate("2014-02-14"));
        anime1.setEnded((java.sql.Date) parseDate("2014-02-14"));
        anime1.setRating(4.6f);
        entityManager.persist(anime1);

        Anime anime2 = new Anime();
        anime2.setTitle("Dragon ball z");
        anime2.setGenre("Aventure");
        anime2.setSynopsis("Kakarot is a sayajin");
        anime1.setAired((java.sql.Date) parseDate("2014-02-14"));
        anime1.setEnded((java.sql.Date) parseDate("2014-02-14"));
        anime1.setRating(4.6f);
        entityManager.persist(anime2);

        Anime anime3 = new Anime();
        anime3.setTitle("Bleach");
        anime3.setGenre("Horror");
        anime3.setSynopsis("Ichigo learn to be shinigami");
        anime1.setAired((java.sql.Date) parseDate("2014-02-14"));
        anime1.setEnded((java.sql.Date) parseDate("2014-02-14"));
        anime1.setRating(4.6f);
        entityManager.persist(anime3);

        Iterable animes = repository.findAll();

        assertThat(animes).hasSize(3).contains(anime1, anime2, anime3);
    }

    @Test
    public void shouldFindAnimeById() {
        Anime anime1 = new Anime();
        anime1.setTitle("Boruto");
        anime1.setGenre("Action");
        anime1.setSynopsis("Naruto is ninja from konoha");
        anime1.setAired((java.sql.Date) parseDate("2014-02-14"));
        anime1.setEnded((java.sql.Date) parseDate("2014-02-14"));
        anime1.setRating(4.6f);
        entityManager.persist(anime1);

        Anime anime2 = new Anime();
        anime2.setTitle("Naruto Shippudden");
        anime2.setGenre("Aventure");
        anime2.setSynopsis("Kakarot is a sayajin");
        anime2.setAired((java.sql.Date) parseDate("2014-02-14"));
        anime2.setEnded((java.sql.Date) parseDate("2014-02-14"));
        anime2.setRating(4.6f);
        entityManager.persist(anime2);

        Anime foundAnime = repository.findById(anime2.getId()).get();

        assertThat(foundAnime).isEqualTo(anime2);
    }

    @Test
    public void findByTitleLike() {
        Anime anime1 = new Anime();
        anime1.setTitle("Boruto");
        anime1.setGenre("Action");
        anime1.setSynopsis("Naruto is ninja from konoha");
        anime1.setAired((java.sql.Date) parseDate("2014-02-14"));
        anime1.setEnded((java.sql.Date) parseDate("2014-02-14"));
        anime1.setRating(4.6f);
        entityManager.persist(anime1);

        Anime anime2 = new Anime();
        anime2.setTitle("Naruto Shippudden");
        anime2.setGenre("Aventure");
        anime2.setSynopsis("Kakarot is a sayajin");
        anime2.setAired((java.sql.Date) parseDate("2014-02-14"));
        anime2.setEnded((java.sql.Date) parseDate("2014-02-14"));
        anime2.setRating(4.6f);
        entityManager.persist(anime2);

        Anime anime3 = new Anime();
        anime3.setTitle("The movie : Naruto");
        anime3.setGenre("Horror");
        anime3.setSynopsis("Ichigo learn to be shinigami");
        anime3.setAired((java.sql.Date) parseDate("2014-02-14"));
        anime3.setEnded((java.sql.Date) parseDate("2014-02-14"));
        anime2.setRating(4.6f);
        entityManager.persist(anime3);

        Iterable<Anime> animes = repository.findByTitleLike("%" + "Naruto" + "%");

        assertThat(animes).hasSize(2).contains(anime2, anime3);
    }

    @Test
    public void shouldUpdateAnimeById() {

        Anime anime1 = new Anime();
        anime1.setTitle("Naruto");
        entityManager.persist(anime1);

        Anime anime2 = new Anime();
        anime2.setTitle("Bleach");
        entityManager.persist(anime2);

        Anime updatedAnime = new Anime();
        updatedAnime.setTitle("Berserk");
        entityManager.persist(updatedAnime);

        Anime anime = repository.findById(anime2.getId()).get();
        anime.setTitle(updatedAnime.getTitle());
        repository.save(anime);

        Anime checkAnime = repository.findById(anime2.getId()).get();

        assertThat(checkAnime.getId()).isEqualTo(anime2.getId());
        assertThat(checkAnime.getTitle()).isEqualTo(updatedAnime.getTitle());
    }

    @Test
    public void shouldDeleteAnimeById() {
        Anime anime1 = new Anime();
        anime1.setTitle("Boruto");
        anime1.setGenre("Action");
        anime1.setSynopsis("Naruto is ninja from konoha");
        anime1.setAired((java.sql.Date) parseDate("2014-02-14"));
        anime1.setEnded((java.sql.Date) parseDate("2014-02-14"));
        anime1.setRating(4.6f);
        entityManager.persist(anime1);

        Anime anime2 = new Anime();
        anime2.setTitle("Naruto Shippudden");
        anime2.setGenre("Aventure");
        anime2.setSynopsis("Kakarot is a sayajin");
        anime2.setAired((java.sql.Date) parseDate("2014-02-14"));
        anime2.setEnded((java.sql.Date) parseDate("2014-02-14"));
        anime2.setRating(4.6f);
        entityManager.persist(anime2);

        Anime anime3 = new Anime();
        anime3.setTitle("The movie : Naruto");
        anime3.setGenre("Horror");
        anime3.setSynopsis("Ichigo learn to be shinigami");
        anime3.setAired((java.sql.Date) parseDate("2014-02-14"));
        anime3.setEnded((java.sql.Date) parseDate("2014-02-14"));
        anime2.setRating(4.6f);
        entityManager.persist(anime3);

        repository.deleteById(anime2.getId());

        Iterable<Anime> tutorials = repository.findAll();

        assertThat(tutorials).hasSize(2).contains(anime1, anime3);
    }

    @Test
    public void shouldDeleteAllAnimes() {
        Anime anime1 = new Anime();
        anime1.setTitle("Boruto");
        anime1.setGenre("Action");
        anime1.setSynopsis("Naruto is ninja from konoha");
        anime1.setAired((java.sql.Date) parseDate("2014-02-14"));
        anime1.setEnded((java.sql.Date) parseDate("2014-02-14"));
        anime1.setRating(4.6f);
        entityManager.persist(anime1);

        Anime anime2 = new Anime();
        anime2.setTitle("Naruto Shippudden");
        anime2.setGenre("Aventure");
        anime2.setSynopsis("Kakarot is a sayajin");
        anime2.setAired((java.sql.Date) parseDate("2014-02-14"));
        anime2.setEnded((java.sql.Date) parseDate("2014-02-14"));
        anime2.setRating(4.6f);
        entityManager.persist(anime2);

        repository.deleteAll();

        assertThat(repository.findAll()).isEmpty();
    }
}
