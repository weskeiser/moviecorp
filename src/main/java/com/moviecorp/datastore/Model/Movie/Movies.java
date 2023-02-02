package com.moviecorp.datastore.Model.Movie;

import com.moviecorp.datastore.Entity.Movie;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movies {
  private Set<Movie> movies;
}
