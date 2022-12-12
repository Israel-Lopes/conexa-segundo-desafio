package com.example.conexaSegundoDesafio.service;

import com.example.conexaSegundoDesafio.persistence.entity.MovieLukeSkyWalkerEntity;
import com.example.conexaSegundoDesafio.integration.MovieLukeSkyWalkerIntegration;
import com.example.conexaSegundoDesafio.web.controller.mapper.MovieLukeSkyWalkerMapper;
import com.example.conexaSegundoDesafio.mock.MockFactory;
import com.example.conexaSegundoDesafio.service.model.MovieLukeSkyWalker;
import com.example.conexaSegundoDesafio.repository.MovieLukeSkyWalkerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MovieLukeSkyWalkerServiceTest {
    private MockFactory mockFactory = new MockFactory();
    @Mock
    private MovieLukeSkyWalkerIntegration integration;

    @Mock
    private MovieLukeSkyWalkerRepository repository;

    @InjectMocks
    private MovieLukeSkyWalkerService service;

    @Test
    public void testGetMoviesSkyWalker() throws Exception {
        List<MovieLukeSkyWalker> models = mockFactory.getMovieLukeSkyWalkerList();

        when(integration.getMoviesSkyWalker()).thenReturn(models);
        when(repository.findAll()).thenReturn((List<MovieLukeSkyWalkerEntity>) MovieLukeSkyWalkerMapper.marshall(models));

        List<MovieLukeSkyWalker> entities = service.getMoviesSkyWalker();
        assertNotNull(entities);
        assertEquals(1, entities.size());

        verify(integration, times(1)).getMoviesSkyWalker();
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testCreateMovieLukeSkyWalker() throws Exception {
        MovieLukeSkyWalker model = mockFactory.getMovieLukeSkyWalker();

        when(repository.save(MovieLukeSkyWalkerMapper.marshall(model)))
                .thenReturn(MovieLukeSkyWalkerMapper.marshall(model));

        MovieLukeSkyWalker saved = service.createMovieLukeSkyWalker(model);
        assertNotNull(saved);

        verify(repository, times(1))
                .save(MovieLukeSkyWalkerMapper.marshall(model));
    }
}
