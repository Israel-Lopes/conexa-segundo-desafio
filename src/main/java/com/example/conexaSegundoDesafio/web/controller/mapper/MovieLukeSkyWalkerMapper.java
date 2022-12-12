package com.example.conexaSegundoDesafio.web.controller.mapper;

import com.example.conexaSegundoDesafio.persistence.entity.MovieLukeSkyWalkerEntity;
import com.example.conexaSegundoDesafio.service.model.MovieLukeSkyWalker;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieLukeSkyWalkerMapper {
    private MovieLukeSkyWalkerMapper() { super(); }
    public static Collection<MovieLukeSkyWalkerEntity> marshall(Collection<MovieLukeSkyWalker> models){
        return models.stream().map(MovieLukeSkyWalkerMapper::marshall).collect(Collectors.toList());
    }
    public static Collection<MovieLukeSkyWalker> unmarshall(Collection<MovieLukeSkyWalkerEntity> entitys){
        return entitys.stream().map(MovieLukeSkyWalkerMapper::unmarshall).collect(Collectors.toList());
    }
    public static MovieLukeSkyWalkerEntity marshall(MovieLukeSkyWalker model) {
        return MovieLukeSkyWalkerEntity.builder()
                .title(model.getTitle())
                .director(model.getDirector())
                .episodeId(model.getEpisodeId())
                .releaseDate(model.getReleaseDate())
                .build();
    }
    public static MovieLukeSkyWalker unmarshall(MovieLukeSkyWalkerEntity entity) {
        return MovieLukeSkyWalker.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .director(entity.getDirector())
                .episodeId(entity.getEpisodeId())
                .releaseDate(entity.getReleaseDate())
                .build();
    }
}
