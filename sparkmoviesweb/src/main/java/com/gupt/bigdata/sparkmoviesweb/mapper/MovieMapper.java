package com.gupt.bigdata.sparkmoviesweb.mapper;

import com.gupt.bigdata.sparkmoviesweb.entity.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MovieMapper {
    @Select("select * from movieinfo")
    public List<Movie> getAllMovies();

    //随机获取10个电影
    @Select("SELECT * FROM movieinfo ORDER BY RAND() LIMIT 10")
    public List<Movie> getTenMovies();

}
