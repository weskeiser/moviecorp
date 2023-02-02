package com.moviecorp.datastore.Controller;

import com.moviecorp.datastore.Model.Franchise.*;
import com.moviecorp.datastore.Model.Movie.*;
import com.moviecorp.datastore.Model.MovieCharacter.MovieCharacterIds;
import com.moviecorp.datastore.Service.*;
import io.swagger.v3.oas.annotations.Operation;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/franchises")
public class FranchiseController {

  @Autowired private FranchiseService franchiseService;

  @Autowired private MovieService movieService;

  @Operation(summary = "Add a new franchise")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public FranchiseDTO addNewFranchise(@RequestBody FranchiseDTO franchiseDTO) {
    return franchiseService.save(franchiseDTO);
  }

  @Operation(summary = "Update a franchise")
  @PutMapping("/{franchiseId}")
  public FranchiseDTO updateFranchise(
      @RequestBody FranchiseDTO franchiseDTO, @PathVariable Long franchiseId) {

    franchiseService.validateExists(franchiseId);

    return franchiseService.save(franchiseDTO);
  }

  @Operation(summary = "Get all franchises")
  @GetMapping
  public FranchisesDTO getAllFranchises() {
    return franchiseService.getAll();
  }

  @Operation(summary = "Delete one franchise")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{franchiseId}")
  public void deleteFranchise(@PathVariable Long franchiseId) {
    franchiseService.delete(franchiseId);
  }

  @Operation(summary = "Get one franchise by ID")
  @GetMapping("/{franchiseId}")
  public FranchiseDTO getFranchiseById(@PathVariable Long franchiseId) {
    return franchiseService.getById(franchiseId);
  }

  // -------------- Movies

  @Operation(summary = "Get all movies in a franchise")
  @GetMapping("/{franchiseId}/movies")
  public MovieIds getMovies(@PathVariable Long franchiseId) {
    return franchiseService.getAllMovies(franchiseId);
  }

  @Operation(summary = "Add movies to a franchise")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PutMapping("/{franchiseId}/movies")
  public void addMovies(@RequestBody Set<Long> movieIds, @PathVariable Long franchiseId) {

    franchiseService.validateExists(franchiseId);

    var franchise = franchiseService.getById(franchiseId);

    movieService.setFranchise(movieIds, franchise);
  }

  @Operation(summary = "Remove movies from a franchise")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{franchiseId}/movies")
  public void removeMovies(@PathVariable Long franchiseId) {

    franchiseService.validateExists(franchiseId);

    var franchise = franchiseService.getById(franchiseId);

    franchise.getMovies().forEach(m -> movieService.removeFranchise(m.getMovieId()));
  }

  // -------------- Characters

  @Operation(summary = "Get all characters in franchise")
  @GetMapping("/{franchiseId}/characters")
  public MovieCharacterIds getAllCharacters(@PathVariable Long franchiseId) {
    return franchiseService.getAllCharacters(franchiseId);
  }
}
