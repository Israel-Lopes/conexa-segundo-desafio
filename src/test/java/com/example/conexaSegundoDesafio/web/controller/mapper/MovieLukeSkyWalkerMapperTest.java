package com.example.conexaSegundoDesafio.web.controller.mapper;

import com.example.conexaSegundoDesafio.persistence.entity.MovieLukeSkyWalkerEntity;
import com.example.conexaSegundoDesafio.mock.MockFactory;
import com.example.conexaSegundoDesafio.service.model.MovieLukeSkyWalker;
import com.example.conexaSegundoDesafio.web.controller.mapper.MovieLukeSkyWalkerMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class MovieLukeSkyWalkerMapperTest {
    private MockFactory mockFactory = new MockFactory();

    @Mock
    private MovieLukeSkyWalkerEntity entity;
    @Mock
    private MovieLukeSkyWalker model;

    @BeforeEach
    void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Deveria converter model para entity")
    void shouldConvertModelToEntity() throws Exception {
       entity = MovieLukeSkyWalkerMapper.marshall(mockFactory.getMockFactory().getMovieLukeSkyWalker());
       assertNotNull(entity);
    }

    @Test
    @DisplayName("Deveria converter entity para model")
    void shouldConvertEntityToModel() throws Exception {
        model = MovieLukeSkyWalkerMapper.unmarshall(mockFactory.getMockFactory().getMovieLukeSkyWalkerEntity());
        assertNotNull(model);
    }
}
