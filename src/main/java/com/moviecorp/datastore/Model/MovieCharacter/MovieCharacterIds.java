package com.moviecorp.datastore.Model.MovieCharacter;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieCharacterIds {

  private Set<MovieCharacterId> characterIds;
}
