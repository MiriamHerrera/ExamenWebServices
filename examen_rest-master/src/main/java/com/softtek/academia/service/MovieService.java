package com.softtek.academia.service;

import java.util.List;

import com.softtek.academia.entity.Movie;

public interface MovieService {
	
	public List<Movie> getAllMovies();
	public Movie getMovieById(Integer id);
	public Movie saveMovie(Movie Movie);
	public Movie updateMovie(Movie Movie);
	public void deleteMovieById(Integer id);
	
}
