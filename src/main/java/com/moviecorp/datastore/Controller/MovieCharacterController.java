package com.moviecorp.datastore.Controller;

import com.moviecorp.datastore.Model.Movie.MoviesDTO;
import com.moviecorp.datastore.Model.MovieCharacter.*;
import com.moviecorp.datastore.Service.MovieCharacterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/characters")
public class MovieCharacterController {

  @Autowired private MovieCharacterService charService;

  @Operation(summary = "Add a new character")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public MovieCharacterDTO addNewCharacter(@RequestBody MovieCharacterDTO movieCharacterDTO) {
    return charService.save(movieCharacterDTO);
  }

  @Operation(summary = "Get all characters")
  @GetMapping
  public MovieCharactersDTO getAllCharacters() {
    return charService.getAll();
  }

  @Operation(summary = "Update a character")
  @PutMapping("/{characterId}")
  public MovieCharacterDTO updateCharacter(
      @RequestBody MovieCharacterDTO movieCharacterDTO, @PathVariable Long characterId) {

    charService.validateCharacterExists(characterId);

    movieCharacterDTO.setCharacterId(characterId);

    return charService.save(movieCharacterDTO);
  }

  @Operation(summary = "Get one character by ID")
  @GetMapping("/{characterId}")
  public MovieCharacterDTO getCharacterById(@PathVariable Long characterId) {
    return charService.getById(characterId);
  }

  @Operation(summary = "Delete one character")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{characterId}")
  public void deleteCharacter(@PathVariable Long characterId) {
    charService.delete(characterId);
  }

  // -------------- Movies

  @Operation(summary = "Get movies for a character by character ID")
  @GetMapping("/{characterId}/movies")
  public MoviesDTO getMovies(@PathVariable Long characterId) {
    return charService.getMovies(characterId);
  }
}
