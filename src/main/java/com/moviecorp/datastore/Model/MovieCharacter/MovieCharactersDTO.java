package com.moviecorp.datastore.Model.MovieCharacter;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieCharactersDTO {
  private Set<MovieCharacterDTO> movieCharacters;
}
