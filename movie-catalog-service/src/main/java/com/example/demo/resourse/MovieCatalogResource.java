package com.example.demo.resourse;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.models.CatalogItem;
import com.example.demo.models.Movie;
import com.example.demo.models.Rating;
import com.example.demo.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	WebClient.Builder webClientBuilder;

	// get all rated movies id

	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId) {
		
		 UserRating ratings =restTemplate
				.getForObject("http://localhost:8083/ratingsdata/users/"+userId, UserRating.class);
		 
	
		return ratings.getUserRating().stream().map(rating -> {
			//this is the new way to use reactively
			/*
			Movie m=webClientBuilder.build()
			.get()//http method
			.uri("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class)
			.retrieve()
			.bodyToMono(Movie.class)
			.block();
			*/
			//this is the old way
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getMovieName(), "description ", rating.getRating(),Integer.parseInt(movie.getMovieId()));
		}).collect(Collectors.toList());

	}

}
