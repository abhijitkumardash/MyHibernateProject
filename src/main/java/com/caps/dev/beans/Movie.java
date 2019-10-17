package com.caps.dev.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movies_info")
public class Movie {
	@Id @Column(name = "movie_id")
	private int movieId;
	
	@Column(name = "movie_name")
	private String name;
	
	@Column(name = "movie_desc")
	private String description;
	
	@Column(name = "movie_rating")
	private int rating;

	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
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
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", name=" + name + ", description=" + description + ", rating=" + rating
				+ "]";
	}
}
