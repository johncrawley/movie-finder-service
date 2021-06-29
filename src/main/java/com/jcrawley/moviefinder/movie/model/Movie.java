package com.jcrawley.moviefinder.movie.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder	
public class Movie {
	@Id
	private String id; 
	
	private String title;
	

}
