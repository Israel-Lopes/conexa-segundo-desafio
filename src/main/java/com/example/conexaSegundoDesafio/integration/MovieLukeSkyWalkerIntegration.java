package com.example.conexaSegundoDesafio.integration;

import com.example.conexaSegundoDesafio.service.model.MovieLukeSkyWalker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(url= "${service.worker.sky}" , name = "sky")
public interface MovieLukeSkyWalkerIntegration {
    @RequestMapping(method = RequestMethod.GET, value = "/sky")
    List<MovieLukeSkyWalker> getMoviesSkyWalker();
}
