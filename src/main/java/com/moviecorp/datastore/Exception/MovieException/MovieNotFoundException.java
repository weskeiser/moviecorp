package com.moviecorp.datastore.Exception.MovieException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException {
  public MovieNotFoundException(String message) {
    super(message);
  }

  public MovieNotFoundException(Long movieId) {
    super("Movie  not found with the ID: " + movieId);
  }
}
