package com.moviecorp.datastore.Exception.MovieCharacterException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieCharacterNotFoundException extends RuntimeException {
  public MovieCharacterNotFoundException(String message) {
    super(message);
  }

  public MovieCharacterNotFoundException(Long characterId) {
    super("Movie character not found with the ID: " + characterId);
  }
}
