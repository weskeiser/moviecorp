package com.moviecorp.datastore.Service;

import com.moviecorp.datastore.Entity.Movie;
import com.moviecorp.datastore.Entity.MovieCharacter;
import com.moviecorp.datastore.Exception.MovieCharacterException.MovieCharacterNotFoundException;
import com.moviecorp.datastore.Model.Movie.MoviesDTO;
import com.moviecorp.datastore.Model.MovieCharacter.*;
import com.moviecorp.datastore.Repository.MovieCharacterRepo;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class MovieCharacterService {

  private final MovieCharacterRepo characterRepo;

  @Autowired private ConversionService convertSvc;

  public MovieCharacterService(MovieCharacterRepo characterRepo) {
    this.characterRepo = characterRepo;
  }

  public MovieCharacterDTO save(MovieCharacterDTO characterDTO) {

    var character = convert(characterDTO, MovieCharacter.class);

    var savedCharacter = characterRepo.save(character);

    return convert(savedCharacter, MovieCharacterDTO.class);
  }

  public void delete(Long characterId) {
    characterRepo.deleteById(characterId);
  }

  private MovieCharacter findById(Long id) {
    return characterRepo.findById(id).orElseThrow(() -> new MovieCharacterNotFoundException(id));
  }

  public MovieCharacterDTO getById(Long id) {

    var character = findById(id);

    return convert(character, MovieCharacterDTO.class);
  }

  public MovieCharactersDTO getAllById(Set<Long> ids) {

    var characterSet = new HashSet<MovieCharacter>(characterRepo.findAllById(ids));

    var characters = convert(characterSet, MovieCharacters.class);

    return convert(characters, MovieCharactersDTO.class);
  }

  public MovieCharactersDTO getAll() {

    var charactersSet = new HashSet<MovieCharacter>(characterRepo.findAll());

    var characters = convert(charactersSet, MovieCharacters.class);

    return convert(characters, MovieCharactersDTO.class);
  }

  public void validateCharacterExists(Long characterId) {

    if (!characterRepo.existsById(characterId))
      throw new MovieCharacterNotFoundException(characterId);
  }

  // -------------- Movies

  public MoviesDTO getMovies(Long characterId) {

    var character = findById(characterId);

    var movieSet = new HashSet<Movie>(character.getMovies());

    return convert(movieSet, MoviesDTO.class);
  }

  // --------------

  private <T> T convert(@Nullable Object source, Class<T> targetType) {
    return convertSvc.convert(source, targetType);
  }
}
