package com.sutorimingu.no.sekai.model;

/**
 * @author ufhopla
 * on 07/08/2021.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "files")
public class FileDB {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @JsonIgnore
    private String name;
    @JsonIgnore
    private String type;

    @Lob
    @JsonIgnore
    private byte[] data;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "anime_id")
    public Anime anime;

    public FileDB(final String name, final String type, final byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

}
