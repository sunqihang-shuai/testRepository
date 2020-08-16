package com.fh.sqh.model;

import com.fh.sqh.utils.DataTablePageBean;

public class MovieSelect extends DataTablePageBean {

    private String movieName;

    private Integer homeId;

    private Integer movieNum;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getHomeId() {
        return homeId;
    }

    public void setHomeId(Integer homeId) {
        this.homeId = homeId;
    }

    public Integer getMovieNum() {
        return movieNum;
    }

    public void setMovieNum(Integer movieNum) {
        this.movieNum = movieNum;
    }
}
