 package io.javabrains.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.model.Rating;
import io.javabrains.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable String movieId) {
		return new Rating("La Cosa",4);
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getRating1(@PathVariable String userId) {
		List<Rating> ratings=Arrays.asList(
				new Rating("1234",4),
				new Rating("5678",3)				
				);
		
		UserRating userRating=new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}

}
