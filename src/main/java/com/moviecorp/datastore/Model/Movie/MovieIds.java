package com.moviecorp.datastore.Model.Movie;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieIds {
  Set<MovieId> movieIds;
}
