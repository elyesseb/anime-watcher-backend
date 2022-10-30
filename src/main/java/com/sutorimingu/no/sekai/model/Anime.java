package com.sutorimingu.no.sekai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
// Indique que la classe est une classe Java persistante
@Data
// Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
@NoArgsConstructor
public class Anime {
    @Id
    // la clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // champ à incrémentation automatique
    private Long id;
    private String title;
    private String genre;
    @Column(columnDefinition="TEXT")
    // type de donnée SQL en Text au lieu de Varchar
    private String synopsis;
    private Date aired;
    private Date ended;
    private Float rating;
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "files_id")
    // la Clé étrangère
    public FileDB fileDB;
}
