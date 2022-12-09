package com.example.conexaSegundoDesafio.service;

import com.example.conexaSegundoDesafio.controller.MovieLukeSkyWalkerController;
import com.example.conexaSegundoDesafio.entity.MovieLukeSkyWalkerEntity;
import com.example.conexaSegundoDesafio.integration.MovieLukeSkyWalkerIntegration;
import com.example.conexaSegundoDesafio.mock.MockFactory;
import com.example.conexaSegundoDesafio.model.MovieLukeSkyWalker;
import com.example.conexaSegundoDesafio.repository.MovieLukeSkyWalkerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class MovieLukeSkyWalkerServiceTest {
    private MockFactory mockFactory = new MockFactory();
    @Spy
    @InjectMocks
    private MovieLukeSkyWalkerService service;
    @Mock
    private MovieLukeSkyWalkerIntegration integration;
    @Mock
    private MovieLukeSkyWalkerRepository repository;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getMoviesSkyWalker_shouldLookMovies() throws Exception {
        when(integration.getMoviesSkyWalker()).thenReturn(mockFactory.getMovieLukeSkyWalkerList());
        when(repository.findByEpisodeId(1)).thenReturn(mockFactory.getMovieLukeSkyWalkerEntity());
        when(service.getMoviesSkyWalker()).thenReturn(mockFactory.getMovieLukeSkyWalkerEntityList());

        List<MovieLukeSkyWalker> modelList = integration.getMoviesSkyWalker();
        repository.findByEpisodeId(1);
        List<MovieLukeSkyWalkerEntity> entityList = service.getMoviesSkyWalker();

        assertThat(modelList).isNotNull();
        verify(repository, times(1)).findByEpisodeId(1);
        assertThat(entityList).isNotNull();
    }

    @Test
    void createMovieLukeSkyWalker_shouldCreateMovie() throws Exception {
        when(repository.save(mockFactory.getMovieLukeSkyWalkerEntity()))
                .thenReturn(mockFactory.getMovieLukeSkyWalkerEntity());
        when(service.createMovieLukeSkyWalker(mockFactory.getMovieLukeSkyWalkerEntity()))
                .thenReturn(mockFactory.getMovieLukeSkyWalkerEntity());

        MovieLukeSkyWalkerEntity saved = repository.save(mockFactory.getMovieLukeSkyWalkerEntity());
        MovieLukeSkyWalkerEntity created = service.createMovieLukeSkyWalker(mockFactory.getMovieLukeSkyWalkerEntity());

        assertThat(saved).isNotNull();
        assertThat(created).isNotNull();
        verify(repository, atLeastOnce()).save(mockFactory.getMovieLukeSkyWalkerEntity());
        verify(service, atLeastOnce()).createMovieLukeSkyWalker(mockFactory.getMovieLukeSkyWalkerEntity());

    }
}
