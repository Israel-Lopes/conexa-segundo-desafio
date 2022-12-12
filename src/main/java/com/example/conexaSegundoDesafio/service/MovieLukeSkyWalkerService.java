package com.example.conexaSegundoDesafio.service;

import com.example.conexaSegundoDesafio.persistence.entity.MovieLukeSkyWalkerEntity;
import com.example.conexaSegundoDesafio.integration.MovieLukeSkyWalkerIntegration;
import com.example.conexaSegundoDesafio.web.controller.mapper.MovieLukeSkyWalkerMapper;
import com.example.conexaSegundoDesafio.service.model.MovieLukeSkyWalker;
import com.example.conexaSegundoDesafio.repository.MovieLukeSkyWalkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieLukeSkyWalkerService {
    public static final Logger log = LoggerFactory.getLogger(MovieLukeSkyWalkerService.class);
    @Autowired(required=true)
    private MovieLukeSkyWalkerIntegration integration;
    @Autowired(required=true)
    private MovieLukeSkyWalkerRepository repository;

    public List<MovieLukeSkyWalker> getMoviesSkyWalker() throws Exception {
        log.info("Iniciando busca de filmes do Skywalker na integracao");
        List<MovieLukeSkyWalker> integration = this.integration.getMoviesSkyWalker();

        integration.forEach(model -> {
            MovieLukeSkyWalkerEntity entity = repository.findByEpisodeId(model.getEpisodeId());
            if (entity == null) {
                repository.save(MovieLukeSkyWalkerMapper.marshall(model));
                log.info("Item salvo com sucesso! {}", model);
            }
        });

        return (List)MovieLukeSkyWalkerMapper.unmarshall(repository.findAll());
    }

    public MovieLukeSkyWalker createMovieLukeSkyWalker(MovieLukeSkyWalker model) throws Exception {
        MovieLukeSkyWalkerEntity db = repository.save(MovieLukeSkyWalkerMapper.marshall(model));
        MovieLukeSkyWalker saved = MovieLukeSkyWalkerMapper.unmarshall(db);
        log.info("Filme salvo com sucesso: {}", saved);
        return saved;
    }

}
