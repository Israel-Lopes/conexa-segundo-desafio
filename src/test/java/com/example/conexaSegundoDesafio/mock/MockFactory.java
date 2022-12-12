package com.example.conexaSegundoDesafio.mock;

import com.example.conexaSegundoDesafio.persistence.entity.MovieLukeSkyWalkerEntity;
import com.example.conexaSegundoDesafio.service.model.MovieLukeSkyWalker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MockFactory {
    public static MockFactory getMockFactory() { return new MockFactory(); }

    public  Collection<MovieLukeSkyWalker> getMovieLukeSkyWalkerCollection() {
        Collection<MovieLukeSkyWalker> collection = new ArrayList<>();
        collection.add(getMovieLukeSkyWalker());
        return collection;
    }
    public List<MovieLukeSkyWalker> getMovieLukeSkyWalkerList() {
        List<MovieLukeSkyWalker> list = new ArrayList<>();
        list.add(getMovieLukeSkyWalker());
        return list;
    }
    public static MovieLukeSkyWalker getMovieLukeSkyWalker() {
        return MovieLukeSkyWalker.builder()
                .id(1L)
                .title("title-teste")
                .episodeId(1)
                .director("director-teste")
                .releaseDate(LocalDate.now())
                .build();
    }
    public List<MovieLukeSkyWalkerEntity> getMovieLukeSkyWalkerEntityList() {
        List<MovieLukeSkyWalkerEntity> list = new ArrayList<>();
        list.add(getMovieLukeSkyWalkerEntity());
        return list;
    }
    public static MovieLukeSkyWalkerEntity getMovieLukeSkyWalkerEntity() {
        return MovieLukeSkyWalkerEntity.builder()
                .id(1L)
                .title("title-teste")
                .episodeId(1)
                .director("director-teste")
                .releaseDate(LocalDate.now())
                .build();
    }
}
