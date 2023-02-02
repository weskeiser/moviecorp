package com.moviecorp.datastore.Entity;

import jakarta.persistence.*;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "movie")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long movieId;

  @Column(nullable = false, length = 100)
  private String title;

  @Column(nullable = false, length = 100)
  private String genre;

  @Column(nullable = false, length = 4)
  private int releaseYear;

  @Column(length = 50)
  private String director;

  private String pictureUrl;

  private String trailerUrl;

  @ManyToOne
  @JoinColumn(name = "franchise_id", nullable = true)
  private Franchise franchise;

  @ManyToMany(
      cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
  @JoinTable(
      name = "character_movie_link",
      joinColumns = {@JoinColumn(name = "movie_id")},
      inverseJoinColumns = {@JoinColumn(name = "character_id")})
  private Set<MovieCharacter> movieCharacters;
}
