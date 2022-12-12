package com.example.conexaSegundoDesafio.web.controller;

import com.example.conexaSegundoDesafio.service.model.MovieLukeSkyWalker;
import com.example.conexaSegundoDesafio.service.MovieLukeSkyWalkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sky")
public class MovieLukeSkyWalkerController {
    @Autowired(required=true)
    MovieLukeSkyWalkerService service;

    @GetMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<MovieLukeSkyWalker> getSky() throws Exception {
        return service.getMoviesSkyWalker();
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public MovieLukeSkyWalker createMovieLukeSkyWalker(@RequestBody MovieLukeSkyWalker model) throws Exception {
        return service.createMovieLukeSkyWalker(model);
    }

}
