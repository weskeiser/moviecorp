package com.moviecorp.datastore.Model.Movie;

import java.util.Set;
import lombok.Data;

@Data
public class MoviesDTO {
  private Set<MovieDTO> movies;
}
