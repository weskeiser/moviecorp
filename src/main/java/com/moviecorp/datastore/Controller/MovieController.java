package com.moviecorp.datastore.Controller;

import com.moviecorp.datastore.Model.Movie.*;
import com.moviecorp.datastore.Model.MovieCharacter.MovieCharactersDTO;
import com.moviecorp.datastore.Service.*;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/movies")
public class MovieController {

  @Autowired private MovieService movieService;

  @Autowired private MovieCharacterService movieCharacterService;

  @Operation(summary = "Add a new movie")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public MovieDTO addNewMovie(@RequestBody MovieNew movieNew) {
    return movieService.save(movieNew);
  }

  @Operation(summary = "Get all movies")
  @GetMapping
  public MoviesDTO getAllMovies() {
    return movieService.getAll();
  }

  @Operation(summary = "Get one movie by ID")
  @GetMapping("/{movieId}")
  public MovieDTO getMovieById(@PathVariable Long movieId) {
    return movieService.getById(movieId);
  }

  @Operation(summary = "Update a movie")
  @PutMapping("/{movieId}")
  public MovieDTO updateMovie(@RequestBody MovieUpdate movieUpdate, @PathVariable Long movieId) {

    movieService.validateExists(movieId);

    movieUpdate.setMovieId(movieId);

    return movieService.save(movieUpdate);
  }

  @Operation(summary = "Delete one movie")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{movieId}")
  public void deleteMovie(@PathVariable Long movieId) {
    movieService.delete(movieId);
  }

  // -------------- Characters

  @GetMapping("/{movieId}/characters")
  @Operation(summary = "Get all characters in a movie")
  public MovieCharactersDTO getMovieCharacters(@PathVariable Long movieId) {
    return movieService.getAllCharacters(movieId);
  }

  @PutMapping("/{movieId}/characters")
  @Operation(summary = "Add characters to a movie")
  public MovieCharactersDTO addMovieCharacters(
      @RequestBody Set<Long> characterIds, @PathVariable Long movieId) {

    var newCharacters = movieCharacterService.getAllById(characterIds);

    return movieService.addCharacters(newCharacters, movieId);
  }

  @DeleteMapping("/{movieId}/characters")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(summary = "Remove characters from a movie")
  public void removeMovieCharacters(@RequestBody List<Long> charIds, @PathVariable Long movieId) {

    movieService.removeCharacters(charIds, movieId);
  }
}
