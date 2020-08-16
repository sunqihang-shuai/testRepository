package com.fh.sqh.service.impl;

import com.fh.sqh.mapper.MovieMapper;
import com.fh.sqh.model.Home;
import com.fh.sqh.model.Movie;
import com.fh.sqh.model.MovieSelect;
import com.fh.sqh.service.MovieService;
import com.fh.sqh.utils.DataTableResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    @Resource
    private MovieMapper movieMapper;

    @Override
    public DataTableResult queryMovie(MovieSelect movieSelect) {
        Long count = movieMapper.queryCount(movieSelect);

        List<Movie> goodsList = movieMapper.queryMovie(movieSelect);

        DataTableResult dataTableResult = new DataTableResult();

        dataTableResult.setDraw(movieSelect.getDraw());

        dataTableResult.setData(goodsList);

        dataTableResult.setRecordsFiltered(count);

        dataTableResult.setRecordsTotal(count);

        return dataTableResult;
    }

    @Override
    public List<Home> queryHome() {
        return movieMapper.queryHome();
    }

    @Override
    public void addMovie(Movie movie) {
        movieMapper.addMovie(movie);
    }

    @Override
    public void updateMovieById(Integer movieId) {
        movieMapper.updateMovieById(movieId);
    }

    @Override
    public Movie selectMovieById(Integer movieId) {
        return movieMapper.selectMovieById(movieId);
    }
}
