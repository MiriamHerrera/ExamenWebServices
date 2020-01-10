package com.softtek.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academia.entity.Movie;

import com.softtek.academia.service.MovieService;

@RestController
@RequestMapping ("/api")
public class MainRestController {
	
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/movies")
	private List<Movie> getMovie() {
		return movieService.getAllMovies();
	}
	
	@GetMapping("/movies/{id}")
	private Movie getMovieById(@PathVariable Integer id) {
		return movieService.getMovieById(id);
	}
	
	@PostMapping("/movies/add")
	@ResponseStatus(HttpStatus.CREATED)
	private Movie addMovie(@RequestBody Movie requestBody) {
		return movieService.saveMovie(requestBody);
	}
	
	@PutMapping(value ="/movies/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	private Movie updateMovie (@PathVariable Integer id, @RequestBody Movie requestBody) {
		return movieService.saveMovie(requestBody);
	}
	
	@DeleteMapping("/movies/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	private void deleteMovie(@PathVariable Integer id) {
		movieService.deleteMovieById(id);
	}

}
