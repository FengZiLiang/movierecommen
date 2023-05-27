package com.gupt.bigdata.sparkmoviesweb.controller;

import com.gupt.bigdata.sparkmoviesweb.entity.Movie;
import com.gupt.bigdata.sparkmoviesweb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    public MovieService movieService;

    @RequestMapping("/all")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    };
    //随机获取10个电影
    @RequestMapping("/10movies")
    public List<Movie> getTenMovies(){
        return movieService.getTenMovies();
    };
}
