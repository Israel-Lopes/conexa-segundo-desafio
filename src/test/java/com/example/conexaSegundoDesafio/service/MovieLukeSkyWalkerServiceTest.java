package com.example.conexaSegundoDesafio.service;

import com.example.conexaSegundoDesafio.controller.MovieLukeSkyWalkerController;
import com.example.conexaSegundoDesafio.entity.MovieLukeSkyWalkerEntity;
import com.example.conexaSegundoDesafio.integration.MovieLukeSkyWalkerIntegration;
import com.example.conexaSegundoDesafio.mapper.MovieLukeSkyWalkerMapper;
import com.example.conexaSegundoDesafio.mock.MockFactory;
import com.example.conexaSegundoDesafio.model.MovieLukeSkyWalker;
import com.example.conexaSegundoDesafio.repository.MovieLukeSkyWalkerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MovieLukeSkyWalkerServiceTest {

    @Mock
    private MovieLukeSkyWalkerIntegration integration;

    @Mock
    private MovieLukeSkyWalkerRepository repository;

    @InjectMocks
    private MovieLukeSkyWalkerService service;

    @Test
    public void testGetMoviesSkyWalker() throws Exception {
        List<MovieLukeSkyWalker> models = new ArrayList<>();
        models.add(MovieLukeSkyWalker.builder()
                .id(1L)
                .title("The Empire Strikes Back")
                .episodeId(5)
                .director("Irvin Kershner")
                .releaseDate(LocalDate.of(1980, 5, 17))
                .build());

        when(integration.getMoviesSkyWalker()).thenReturn(models);
        when(repository.findAll()).thenReturn((List<MovieLukeSkyWalkerEntity>) MovieLukeSkyWalkerMapper.marshall(models));

        List<MovieLukeSkyWalkerEntity> entities = service.getMoviesSkyWalker();
        assertNotNull(entities);
        assertEquals(1, entities.size());

        verify(integration, times(1)).getMoviesSkyWalker();
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testCreateMovieLukeSkyWalker() throws Exception {
        MovieLukeSkyWalkerEntity entity = MovieLukeSkyWalkerEntity.builder()
                .id(1L)
                .title("The Empire Strikes Back")
                .episodeId(5)
                .director("Irvin Kershner")
                .releaseDate(LocalDate.of(1980, 5, 17))
                .build();

        when(repository.save(entity)).thenReturn(entity);

        MovieLukeSkyWalkerEntity saved = service.createMovieLukeSkyWalker(entity);
        assertNotNull(saved);
        assertEquals(1L, saved.getId().longValue());

        verify(repository, times(1)).save(entity);
    }
}
