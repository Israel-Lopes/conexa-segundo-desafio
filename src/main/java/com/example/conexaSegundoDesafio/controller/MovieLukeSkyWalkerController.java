package com.example.conexaSegundoDesafio.controller;

import com.example.conexaSegundoDesafio.entity.MovieLukeSkyWalkerEntity;
import com.example.conexaSegundoDesafio.mapper.MovieLukeSkyWalkerMapper;
import com.example.conexaSegundoDesafio.model.MovieLukeSkyWalker;
import com.example.conexaSegundoDesafio.service.MovieLukeSkyWalkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/sky")
public class MovieLukeSkyWalkerController {
    @Autowired(required=true)
    MovieLukeSkyWalkerService service;

    @GetMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Collection<MovieLukeSkyWalker> getSky() throws Exception {
        List<MovieLukeSkyWalkerEntity> films = service.getMoviesSkyWalker();
        return MovieLukeSkyWalkerMapper.unmarshall(films);
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public MovieLukeSkyWalker createMovieLukeSkyWalker(@RequestBody MovieLukeSkyWalker model) throws Exception {
        MovieLukeSkyWalkerEntity entity = MovieLukeSkyWalkerMapper.marshall(model);
        MovieLukeSkyWalker created = MovieLukeSkyWalkerMapper.unmarshall(service.createMovieLukeSkyWalker(entity));
        return created;
    }

}
