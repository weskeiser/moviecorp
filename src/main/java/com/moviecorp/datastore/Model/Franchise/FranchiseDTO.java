package com.moviecorp.datastore.Model.Franchise;

import com.moviecorp.datastore.Model.Movie.MovieId;
import java.util.Set;
import lombok.Data;

@Data
public class FranchiseDTO {

  private Long franchiseId;

  private String name;

  private String description;

  private Set<MovieId> movies;
}
