package com.example.conexaSegundoDesafio.service;

import com.example.conexaSegundoDesafio.entity.MovieLukeSkyWalkerEntity;
import com.example.conexaSegundoDesafio.integration.MovieLukeSkyWalkerIntegration;
import com.example.conexaSegundoDesafio.mapper.MovieLukeSkyWalkerMapper;
import com.example.conexaSegundoDesafio.model.MovieLukeSkyWalker;
import com.example.conexaSegundoDesafio.repository.MovieLukeSkyWalkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieLukeSkyWalkerService {
    public static final Logger log = LoggerFactory.getLogger(MovieLukeSkyWalkerService.class);
    @Autowired(required=true)
    private MovieLukeSkyWalkerIntegration integration;
    @Autowired(required=true)
    private MovieLukeSkyWalkerRepository repository;

    public List<MovieLukeSkyWalkerEntity> getMoviesSkyWalker() throws Exception {
        log.info("Iniciando busca de filmes do Skywalker na integracao");
        ArrayList<MovieLukeSkyWalker> integration = (ArrayList<MovieLukeSkyWalker>) this.integration.getMoviesSkyWalker();

        for (int i = 0; i < integration.size(); i++) {
            MovieLukeSkyWalkerEntity entity = repository.findByEpisodeId(integration.get(i).getEpisodeId());
            try {
                entity.getEpisodeId().equals(NullPointerException.class);
            } catch (NullPointerException e) {
                repository.save(MovieLukeSkyWalkerMapper.marshall(integration.get(i)));
                log.info("Item salvo com sucesso! {}", MovieLukeSkyWalkerMapper.marshall(integration.get(i)));
            }
        }

        return repository.findAll();
    }

    public MovieLukeSkyWalkerEntity createMovieLukeSkyWalker(MovieLukeSkyWalkerEntity entity) throws Exception {
        MovieLukeSkyWalkerEntity saved = repository.save(entity);
        log.info("Filme salvo com sucesso: {}", saved);
        return saved;
    }

}
