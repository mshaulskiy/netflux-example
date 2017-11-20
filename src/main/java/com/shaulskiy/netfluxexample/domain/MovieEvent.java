package com.shaulskiy.netfluxexample.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class MovieEvent {

    private String movieId;
    private Date date;

    public MovieEvent(String movieId, Date date) {
        this.movieId = movieId;
        this.date = date;
    }
}
