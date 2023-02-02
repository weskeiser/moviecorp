package com.moviecorp.datastore.Model.MovieCharacter;

import com.moviecorp.datastore.Enum.Gender;
import com.moviecorp.datastore.Model.Movie.MovieId;
import java.util.List;
import lombok.Data;

@Data
public class MovieCharacterDTO {

  private Long characterId;

  private String fullName;

  private String alias;

  private Gender gender;

  private String pictureUrl;

  private List<MovieId> movies;
}
