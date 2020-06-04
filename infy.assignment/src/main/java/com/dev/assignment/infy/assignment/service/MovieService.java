package com.dev.assignment.infy.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.assignment.infy.assignment.exception.MovieNotFoundException;
import com.dev.assignment.infy.assignment.model.Movie;
import com.dev.assignment.infy.assignment.repositories.MovieRepository;


@Service
public class MovieService {
	
	// This class is 
	
	@Autowired
	MovieRepository repository;

	public List<Movie> getAllMovies() {
		List<Movie> movieeList = repository.findAll();

		if (movieeList.size() > 0) {
			return movieeList;
		} else {
			return new ArrayList<Movie>();
		}
	}
	
	
	 public Movie getMovieById(Long id) throws MovieNotFoundException
	    {
	        Optional<Movie> movieData = repository.findById(id);
	         
	        if(movieData.isPresent()) {
	            return movieData.get();
	        } else {
	            throw new MovieNotFoundException(" Movie not found the given id");
	        }
	    }

	public List<String> getHighestRatedMovies() {

		List<Movie> movieList = repository.findAll();

		List<String> highestRatedList = new ArrayList<>();
		highestRatedList = movieList.stream().filter(movie -> Integer.parseInt(movie.getRate()) > 4)
				.map(movie -> movie.getName()).collect(Collectors.toList());
		
		//below commented code is to fetch top 5 highest rated movies. 

		/*	movieList.stream().filter(movie -> Integer.parseInt(movie.getRate()) > 4)
						 .distinct()
						 .limit(5)
						 .map(movie -> movie.getName()).collect(Collectors.toList());*/
		
		return highestRatedList;
	}
	
	 public Movie createOrUpdateMovieData(Movie movie) throws MovieNotFoundException
	    {
	        Optional<Movie> movieData = repository.findById(movie.getId());
	         
	        if(movieData.isPresent())
	        {
	            Movie newData = movieData.get();
	            newData.setRate(movie.getRate());
	            newData.setCommentedBy(movie.getCommentedBy());
	            newData = repository.save(newData);
	             
	            return newData;
	        } else {
	        	movie = repository.save(movie);
	             
	            return movie;
	        }
	    }

}
