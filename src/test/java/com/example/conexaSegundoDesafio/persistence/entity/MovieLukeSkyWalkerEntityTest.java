package com.example.conexaSegundoDesafio.persistence.entity;

import com.example.conexaSegundoDesafio.persistence.entity.MovieLukeSkyWalkerEntity;
import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.assertion.Method;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

public class MovieLukeSkyWalkerEntityTest {
    private static final String SPLIT_REGEX = "\\(";

    @Test
    void shouldModel() {

        Long id = Long.min(10, 50);
        String title = "George Lucas";
        Integer episodeId = 3;
        String director = "George Lucas";
        LocalDate releaseDate = LocalDate.now();

        MovieLukeSkyWalkerEntity entity = new MovieLukeSkyWalkerEntity();
        entity.setId(id);
        entity.setTitle(title);
        entity.setEpisodeId(episodeId);
        entity.setDirector(director);
        entity.setReleaseDate(releaseDate);

        MovieLukeSkyWalkerEntity newEntity = new MovieLukeSkyWalkerEntity(
                id, title, episodeId,
                director, releaseDate
        );

        MovieLukeSkyWalkerEntity builderEntity = MovieLukeSkyWalkerEntity
                .builder()
                .id(id)
                .title(title)
                .episodeId(episodeId)
                .director(director)
                .releaseDate(releaseDate)
                .build();

        assertNotNull(entity.toString());
        assertNotNull(newEntity.toString());
        assertNotNull(builderEntity.toString());
        assertEquals(entity.toString(), newEntity.toString());
        assertEquals(entity.toString(), builderEntity.toString());

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
            String builderString = MovieLukeSkyWalkerEntity.builder().toString();
            String MovieLukeSkyWalkerEntityToString = new MovieLukeSkyWalkerEntity().toString();

           assertTrue(MovieLukeSkyWalkerEntityToString.split(SPLIT_REGEX)[1].contains(builderString.split(SPLIT_REGEX)[1]));
        }
    }
