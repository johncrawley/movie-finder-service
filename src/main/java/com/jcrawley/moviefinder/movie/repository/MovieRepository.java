package com.jcrawley.moviefinder.movie.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jcrawley.moviefinder.movie.model.Movie;

public interface MovieRepository extends MongoRepository<Movie, String> {

	List<Movie> findByTitleContaining(String title);
	
}
