package com.moviecorp.datastore.Exception.FranchiseException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FranchiseNotFoundException extends RuntimeException {
  public FranchiseNotFoundException(String message) {
    super(message);
  }

  public FranchiseNotFoundException(Long franchiseId) {
    super("Franchise  not found with the ID: " + franchiseId);
  }
}
