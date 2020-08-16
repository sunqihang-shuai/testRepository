package com.fh.sqh.service;

import com.fh.sqh.model.Home;
import com.fh.sqh.model.Movie;
import com.fh.sqh.model.MovieSelect;
import com.fh.sqh.utils.DataTableResult;

import java.util.List;

public interface MovieService {
    DataTableResult queryMovie(MovieSelect movieSelect);

    List<Home> queryHome();

    void addMovie(Movie movie);

    void updateMovieById(Integer movieId);

    Movie selectMovieById(Integer movieId);
}
