package com.example.conexaSegundoDesafio.mock;

import com.example.conexaSegundoDesafio.entity.MovieLukeSkyWalkerEntity;
import com.example.conexaSegundoDesafio.model.MovieLukeSkyWalker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MockFactory {
    public static MockFactory getMockFactory() { return new MockFactory(); }

    public Collection<MovieLukeSkyWalker> getMovieLukeSkyWalkerCollection() {
        Collection<MovieLukeSkyWalker> collection = new ArrayList<>();
        collection.add(getMovieLukeSkyWalker());
        return collection;
    }
    public List<MovieLukeSkyWalker> getMovieLukeSkyWalkerList() {
        List<MovieLukeSkyWalker> list = new ArrayList<>();
        list.add(getMovieLukeSkyWalker());
        return list;
    }
    public MovieLukeSkyWalker getMovieLukeSkyWalker() {
        return MovieLukeSkyWalker.builder()
                .id(Long.min(10, 50))
                .title("title-teste")
                .episodeId(Integer.min(10, 50))
                .director("director-teste")
                .releaseDate(LocalDate.now())
                .build();
    }
    public List<MovieLukeSkyWalkerEntity> getMovieLukeSkyWalkerEntityList() {
        List<MovieLukeSkyWalkerEntity> list = new ArrayList<>();
        list.add(getMovieLukeSkyWalkerEntity());
        return list;
    }
    public MovieLukeSkyWalkerEntity getMovieLukeSkyWalkerEntity() {
        return MovieLukeSkyWalkerEntity.builder()
                .id(Long.min(10, 50))
                .title("title-teste")
                .episodeId(Integer.min(10, 50))
                .director("director-teste")
                .releaseDate(LocalDate.now())
                .build();
    }
}
