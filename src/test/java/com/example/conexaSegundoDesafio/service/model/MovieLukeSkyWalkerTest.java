package com.example.conexaSegundoDesafio.service.model;

import com.example.conexaSegundoDesafio.persistence.entity.MovieLukeSkyWalkerEntity;
import com.example.conexaSegundoDesafio.service.model.MovieLukeSkyWalker;
import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.assertion.Method;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

public class MovieLukeSkyWalkerTest {
    private static final String SPLIT_REGEX = "\\(";

    @Test
    void shouldModel() {

        Long id = Long.min(10, 50);
        String title = "George Lucas";
        Integer episodeId = 3;
        String director = "George Lucas";
        LocalDate releaseDate = LocalDate.now();

        MovieLukeSkyWalker model = new MovieLukeSkyWalker();
        model.setId(id);
        model.setTitle(title);
        model.setEpisodeId(episodeId);
        model.setDirector(director);
        model.setReleaseDate(releaseDate);

        MovieLukeSkyWalker newModel = new MovieLukeSkyWalker(
                id, title, episodeId,
                director, releaseDate
        );

        MovieLukeSkyWalker builderModel = MovieLukeSkyWalker
                .builder()
                .id(id)
                .title(title)
                .episodeId(episodeId)
                .director(director)
                .releaseDate(releaseDate)
                .build();

        assertNotNull(model.toString());
        assertNotNull(newModel.toString());
        assertNotNull(builderModel.toString());
        assertEquals(model.toString(), newModel.toString());
        assertEquals(model.toString(), builderModel.toString());

    }
    @Test
    void getters() {
        final Class<?> gettersTest = MovieLukeSkyWalkerEntity.class;
        assertPojoMethodsFor(gettersTest).testing(Method.GETTER);
    }

    @Test
    void setters() {
        final Class<?> settersTest = MovieLukeSkyWalkerEntity.class;
        assertPojoMethodsFor(settersTest).testing(Method.SETTER);
    }

    @Test
    void construtores() {
        final Class<?> construtorTest = MovieLukeSkyWalkerEntity.class;
        assertPojoMethodsFor(construtorTest).testing(Method.CONSTRUCTOR);
    }

    @Test
    void equal() {
        final Class<?> equalTest = MovieLukeSkyWalkerEntity.class;
        assertPojoMethodsFor(equalTest).testing(Method.EQUALS);
    }

    @Test
    void builderToString() {
        String builderString = MovieLukeSkyWalker.builder().toString();
        String MovieLukeSkyWalkerToString = new MovieLukeSkyWalker().toString();

        assertTrue(MovieLukeSkyWalkerToString.split(SPLIT_REGEX)[1].contains(builderString.split(SPLIT_REGEX)[1]));
    }
}
