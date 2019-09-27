package com.example.demo.resourse;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.CatalogItem;
import com.example.demo.models.Movie;
import com.example.demo.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	// get all rated movies id

	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId) {
		
		List<Rating> ratings = Arrays.asList(new Rating("100", 5), new Rating("101", 5), new Rating("102", 5),
				new Rating("103", 4));
		
		RestTemplate resTemplate = new RestTemplate();
		return ratings.stream().map(rating -> {
			Movie movie = resTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getMovieName(), "", rating.getRating());
		}).collect(Collectors.toList());

	}

}
