package com.moviecorp.datastore.Entity;

import com.moviecorp.datastore.Enum.Gender;
import jakarta.persistence.*;
import java.util.Set;

@Entity(name = "character")
public class Character {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "character_id")
  private int id;

  @Column(length = 50)
  private String alias;

  @Column(length = 50)
  private String firstName;

  @Column(length = 50)
  private String middleName;

  @Column(length = 50)
  private String lastName;

  @Column(nullable = false, length = 6)
  private Gender gender;

  @Column(name = "picture_url")
  private String pictureURL;

  @ManyToMany(mappedBy = "characters")
  private Set<Movie> movies;
}
