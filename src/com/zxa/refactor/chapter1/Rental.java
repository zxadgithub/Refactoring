package com.zxa.refactor.chapter1;

/**
 * @Description:
 * @Author: zhangxin_an
 * @CreateDate: 2018/7/29 15:33
 */

public class Rental {

    private Movie movie;
    private int   dayRented;

    public Rental(Movie movie, int dayRented) {
        this.movie = movie;
        this.dayRented = dayRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getDayRented() {
        return dayRented;
    }

    public void setDayRented(int dayRented) {
        this.dayRented = dayRented;
    }
}
