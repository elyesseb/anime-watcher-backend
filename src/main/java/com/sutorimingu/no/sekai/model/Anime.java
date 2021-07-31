package com.sutorimingu.no.sekai.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

/**
 * @author sei3
 * on 31/07/2021.
 */
@Entity
@Getter
@Setter
public class Anime {
    @Id
    @GeneratedValue
    private Long anime_id;
    private String title;
    private String genre;
    private String synopsis;
    private Date aired;
    private Date ended;
    private Float rating;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Anime)) return false;
        final Anime anime = (Anime) o;
        return Objects.equals(getAnime_id(), anime.getAnime_id()) && Objects.equals(getTitle(), anime.getTitle()) && Objects.equals(getGenre(), anime.getGenre()) && Objects.equals(getSynopsis(), anime.getSynopsis()) && Objects.equals(getAired(), anime.getAired()) && Objects.equals(getEnded(), anime.getEnded()) && Objects.equals(getRating(), anime.getRating());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnime_id(), getTitle(), getGenre(), getSynopsis(), getAired(), getEnded(), getRating());
    }

    @Override
    public String toString() {
        return "Anime{" +
                "anime_id=" + anime_id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", aired=" + aired +
                ", ended=" + ended +
                ", rating=" + rating +
                '}';
    }
}
