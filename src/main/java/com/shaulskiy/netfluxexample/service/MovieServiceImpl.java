package com.shaulskiy.netfluxexample.service;

import com.shaulskiy.netfluxexample.domain.Movie;
import com.shaulskiy.netfluxexample.domain.MovieEvent;
import com.shaulskiy.netfluxexample.repository.MovieRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * Generate stream of movie events for given movie id
     *
     * @param movieId
     * @return
     */
    @Override
    public Flux<MovieEvent> events(String movieId) {
        return Flux.<MovieEvent>generate(movieEventSynchronousSink -> {
            movieEventSynchronousSink.next(new MovieEvent(movieId, new Date()));
        }).delayElements(Duration.ofSeconds(1));
    }

    /**
     * Get Movie by id
     *
     * @param id
     * @return
     */
    @Override
    public Mono<Movie> getMovieById(String id) {
        return this.movieRepository.findById(id);
    }

    /**
     * Return list of all movies
     *
     * @return
     */
    @Override
    public Flux<Movie> getAllMovies() {
        return this.movieRepository.findAll();
    }
}
