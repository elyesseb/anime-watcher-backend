package com.sutorimingu.no.sekai.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author sei3
 * on 31/07/2021.
 */
@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private String message;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id", nullable = false)
    public User creator;
    private Date post_date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anime_id")
    public Anime anime;

}
