package com.softtek.academia.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academia.entity.Movie;
import com.softtek.academia.repository.MovieRepository;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository repository;

	@Override
	public List<Movie> getAllMovies() {
		return (List<Movie>) repository.findAll();
	}

	@Override
	public Movie getMovieById(Integer id) {
		Movie movie = this.repository.findById(id).orElse(null);
		return movie;
	}

	@Override
	public Movie saveMovie(Movie Movie) {
		repository.save(Movie);
		return Movie;
	}

	@Override
	public void deleteMovieById(Integer id) {
		this.repository.deleteById(id);
		
	}

	@Override
	public Movie updateMovie(Movie Movie) {
		this.repository.save(Movie);
		return Movie;
	}

	
	
	
}
