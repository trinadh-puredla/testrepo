package com.dev.assignment.infy.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MOVIES")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="movie_name")
	private String name;
	@Column(name="movie_desc")
	private String description;
	@Column(name="rating")
	private String rate;
	@Column(name="rating_givenby")
	private String commentedBy;

	public Movie() {
		
	}
   

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	

	public String getCommentedBy() {
		return commentedBy;
	}

	public void setCommentedBy(String commentedBy) {
		this.commentedBy = commentedBy;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public Movie(String name, String description, String rate, String commentedBy) {
		super();
		this.name = name;
		this.description = description;
		this.rate = rate;
		this.commentedBy = commentedBy;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", description=" + description + ", rate=" + rate + ", commentedBy="
				+ commentedBy + "]";
	}


}
