package com.moviecorp.datastore.Entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity(name = "franchise")
public class Franchise {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "franchise_id")
  private int id;

  @Column(nullable = false, length = 50)
  private String name;

  private String description;

  @OneToMany(mappedBy = "franchise")
  private Set<Movie> movies;
}
