package com.example.conexaSegundoDesafio.web.controller;

import com.example.conexaSegundoDesafio.mock.MockFactory;
import com.example.conexaSegundoDesafio.service.model.MovieLukeSkyWalker;
import com.example.conexaSegundoDesafio.service.MovieLukeSkyWalkerService;
import com.example.conexaSegundoDesafio.web.controller.MovieLukeSkyWalkerController;
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
                .thenReturn(mockFactory.getMockFactory().getMovieLukeSkyWalkerList());
        when(controller.getSky())
                .thenReturn(mockFactory.getMovieLukeSkyWalkerList());

        service.getMoviesSkyWalker();

        doReturn(mockFactory.getMovieLukeSkyWalkerCollection()).when(controller).getSky();
        verify(service, Mockito.times(1)).getMoviesSkyWalker();
    }

    @Test
    void createMovieLukeSkyWalker_shouldCreateMovie() throws Exception {
        when(service.createMovieLukeSkyWalker(mockFactory.getMockFactory().getMovieLukeSkyWalker()))
                .thenReturn(mockFactory.getMockFactory().getMovieLukeSkyWalker());

        MovieLukeSkyWalker model = service.createMovieLukeSkyWalker(mockFactory.getMockFactory()
                .getMovieLukeSkyWalker());

        verify(service, times(1))
                .createMovieLukeSkyWalker(mockFactory.getMovieLukeSkyWalker());
        assertThat(model).isNotNull();
    }

}
