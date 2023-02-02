package com.moviecorp.datastore.Model.Movie;

import com.moviecorp.datastore.Model.MovieCharacter.MovieCharacterId;
import java.util.List;
import lombok.Data;

@Data
public class MovieDTO {

  private Long movieId;

  private String title;

  private String genre;

  private int releaseYear;

  private String director;

  private String pictureUrl;

  private String trailerUrl;

  private Long franchiseId;

  private List<MovieCharacterId> movieCharacters;
}
