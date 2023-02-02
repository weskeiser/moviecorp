package com.moviecorp.datastore.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdMissingFromBodyException extends RuntimeException {
  public IdMissingFromBodyException(String message) {
    super(message);
  }

  public IdMissingFromBodyException() {
    super("Invalid request: Id missing from body of request.");
  }
}
