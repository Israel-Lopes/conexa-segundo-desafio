package com.example.conexaSegundoDesafio.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_MOVIE_LUKESKYWALKER")
public class MovieLukeSkyWalkerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "episode_id", nullable = false)
    private Integer episodeId;
    @Column(name = "director", nullable = false)
    private String director;
    @Column(name = "release_date",columnDefinition = "DATE" ,nullable = false)
    private LocalDate releaseDate;

}
