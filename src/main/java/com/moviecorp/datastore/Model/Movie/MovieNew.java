package com.moviecorp.datastore.Model.Movie;

import lombok.Data;

@Data
public class MovieNew {

  private String title;

  private String genre;

  private int releaseYear;

  private String director;

  private String pictureUrl;

  private String trailerUrl;
}
