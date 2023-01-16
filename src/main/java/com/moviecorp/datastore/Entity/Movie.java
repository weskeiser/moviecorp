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

  @ManyToMany private Set<Character> characters;
}
