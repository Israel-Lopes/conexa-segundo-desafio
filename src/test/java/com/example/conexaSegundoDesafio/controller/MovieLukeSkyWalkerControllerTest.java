package com.example.conexaSegundoDesafio.controller;

import com.example.conexaSegundoDesafio.entity.MovieLukeSkyWalkerEntity;
import com.example.conexaSegundoDesafio.mock.MockFactory;
import com.example.conexaSegundoDesafio.service.MovieLukeSkyWalkerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class MovieLukeSkyWalkerControllerTest {
    private MockFactory mockFactory = new MockFactory();
    @Spy
    @InjectMocks
    private MovieLukeSkyWalkerController controller;
    @Mock
    private MovieLukeSkyWalkerService service;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getSky_shouldListMovieSky() throws Exception {
        when(service.getMoviesSkyWalker())
                .thenReturn(mockFactory.getMockFactory().getMovieLukeSkyWalkerEntityList());
        when(controller.getSky())
                .thenReturn(mockFactory.getMovieLukeSkyWalkerCollection());

        service.getMoviesSkyWalker();

        doReturn(mockFactory.getMovieLukeSkyWalkerCollection()).when(controller).getSky();
        verify(service, Mockito.times(1)).getMoviesSkyWalker();
    }

    @Test
    void createMovieLukeSkyWalker_shouldCreateMovie() throws Exception {
        when(service.createMovieLukeSkyWalker(mockFactory.getMockFactory().getMovieLukeSkyWalkerEntity()))
                .thenReturn(mockFactory.getMockFactory().getMovieLukeSkyWalkerEntity());

        MovieLukeSkyWalkerEntity entity = service.createMovieLukeSkyWalker(mockFactory.getMockFactory()
                .getMovieLukeSkyWalkerEntity());

        verify(service, times(1))
                .createMovieLukeSkyWalker(mockFactory.getMovieLukeSkyWalkerEntity());
        assertThat(entity).isNotNull();
    }

}
