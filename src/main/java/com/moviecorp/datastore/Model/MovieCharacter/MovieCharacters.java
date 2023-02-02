package com.moviecorp.datastore.Model.MovieCharacter;

import com.moviecorp.datastore.Entity.MovieCharacter;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieCharacters {
  private Set<MovieCharacter> movieCharacters;
}
