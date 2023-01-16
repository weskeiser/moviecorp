package com.moviecorp.datastore.Entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity(name = "movie")
public class Movie {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "movie_id")
  private int id;

  @Column(nullable = false, length = 100)
  private String title;

  @Column(nullable = false, length = 100)
  private String genre;

  @Column(name = "release_year", nullable = false, length = 4)
  private int releaseYear;

  @Column(nullable = false, length = 50)
  private String director;

  @Column(name = "picture_url")
  private String pictureURL;

  @Column(name = "trailer_url")
  private String trailerURL;

  @ManyToOne
  @JoinColumn(name = "franchise_id")
  private Franchise franchise;

  @ManyToMany private Set<MovieCharacter> movieCharacters;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getPictureURL() {
    return pictureURL;
  }

  public void setPictureURL(String pictureURL) {
    this.pictureURL = pictureURL;
  }

  public String getTrailerURL() {
    return trailerURL;
  }

  public void setTrailerURL(String trailerURL) {
    this.trailerURL = trailerURL;
  }

  public Franchise getFranchise() {
    return franchise;
  }

  public void setFranchise(Franchise franchise) {
    this.franchise = franchise;
  }

  public Set<MovieCharacter> getMovieCharacters() {
    return movieCharacters;
  }

  public void setMovieCharacter(Set<MovieCharacter> movieCharacters) {
    this.movieCharacters = movieCharacters;
  }
}
