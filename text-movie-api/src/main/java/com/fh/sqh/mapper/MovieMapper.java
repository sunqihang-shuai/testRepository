package com.fh.sqh.mapper;

import com.fh.sqh.model.Home;
import com.fh.sqh.model.Movie;
import com.fh.sqh.model.MovieSelect;

import java.util.List;

public interface MovieMapper {
    Long queryCount(MovieSelect movieSelect);

    List<Movie> queryMovie(MovieSelect movieSelect);

    List<Home> queryHome();

    void addMovie(Movie movie);

    void updateMovieById(Integer movieId);

    Movie selectMovieById(Integer movieId);
}
