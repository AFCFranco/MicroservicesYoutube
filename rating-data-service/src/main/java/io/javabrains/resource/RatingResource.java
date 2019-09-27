package io.javabrains.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.model.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable String movieId) {
		return new Rating("La Cosa",4);
	}

}
