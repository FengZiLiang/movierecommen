package com.gupt.bigdata.sparkmoviesweb.service;

import com.gupt.bigdata.sparkmoviesweb.entity.Movie;
import com.gupt.bigdata.sparkmoviesweb.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    public MovieMapper movieMapper;

    public List<Movie> getAllMovies(){
        return movieMapper.getAllMovies();
    };
    //随机获取10个电影
    public List<Movie> getTenMovies(){
        return movieMapper.getTenMovies();
    };
}
