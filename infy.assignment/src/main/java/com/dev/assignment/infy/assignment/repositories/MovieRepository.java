package com.dev.assignment.infy.assignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.assignment.infy.assignment.model.Movie;

@Repository
public interface MovieRepository
       extends JpaRepository<Movie, Long> {

}
