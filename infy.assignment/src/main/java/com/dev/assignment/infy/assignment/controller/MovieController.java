package com.dev.assignment.infy.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.assignment.infy.assignment.exception.MovieNotFoundException;
import com.dev.assignment.infy.assignment.model.Movie;
import com.dev.assignment.infy.assignment.service.MovieService;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {
	
	@Autowired
	MovieService movService;
	
	
	
	//Below end point gives the highest rated movies
	@GetMapping("/highestratedmovies")
	public List<String>  getHighestRatedMovies(){
		
		List<String> movieNamesList=new ArrayList<>();
		
		movieNamesList=movService.getHighestRatedMovies();
				
		return movieNamesList;
		
	}
	
	//Below gives the movie details for the give or requested movieId
	 @GetMapping("/{id}")
	    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id)
	                                                    throws MovieNotFoundException {
	        Movie entity = movService.getMovieById(id);
	 
	        return new ResponseEntity<Movie>(entity, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	 
	 //Below end point will create or update the rating for a given movie by the specific customer
	 @GetMapping("/customer/{cust-id}/rate/{rating}/movie/{movie-id}")
	    public ResponseEntity<Movie> createOrUpdateMovieData(@PathVariable("movie-id") Long id,@PathVariable("cust-id") String custId,@PathVariable("rating") String rating)
	                                                    throws MovieNotFoundException {
		 
		 Movie dataToBeCreatedOrupdated=new Movie();
		 dataToBeCreatedOrupdated.setRate(rating);
		 dataToBeCreatedOrupdated.setCommentedBy(custId);
		 dataToBeCreatedOrupdated.setId(id);
	     Movie movieInfo = movService.createOrUpdateMovieData(dataToBeCreatedOrupdated);
	     return new ResponseEntity<Movie>(movieInfo, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	 @PostMapping("/createorupdate")
	    public ResponseEntity<Movie> createOrUpdateMovieData(Movie movie)
	                                                    throws MovieNotFoundException {
	        Movie updated = movService.createOrUpdateMovieData(movie);
	        return new ResponseEntity<Movie>(updated, new HttpHeaders(), HttpStatus.OK);
	    }


}
