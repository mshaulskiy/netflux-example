package com.shaulskiy.netfluxexample.repository;

import com.shaulskiy.netfluxexample.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
