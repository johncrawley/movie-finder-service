package com.jcrawley.moviefinder.movie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jcrawley.moviefinder.movie.model.Movie;
import com.jcrawley.moviefinder.movie.repository.MovieRepository;

import lombok.AllArgsConstructor;

@RequestMapping("/movie")
@RestController
@AllArgsConstructor
public class MovieController {

	private MovieRepository movieRepository;
	

	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable String id){
		
		Movie movie = movieRepository
				.findById(id)
				.orElseThrow(() -> 
				new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity Not Found."));
		
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
	@GetMapping("/more/{id}")
	public ResponseEntity<Movie> getMovie2(@PathVariable String id){
		
		Movie movie = new Movie("1", "hello test");
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Movie> addNewMovie(Movie movie){
		Movie savedMovie = movieRepository.save(movie);
		return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable String id){
		movieRepository.deleteById(id);
	}
	
}
