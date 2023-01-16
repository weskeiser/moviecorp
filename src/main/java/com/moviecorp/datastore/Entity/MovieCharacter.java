package com.moviecorp.datastore.Entity;

import com.moviecorp.datastore.Enum.Gender;
import jakarta.persistence.*;
import java.util.Set;

@Entity(name = "character")
public class MovieCharacter {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "character_id")
  private Long id;

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

  @ManyToMany(mappedBy = "movieCharacters")
  private Set<Movie> movies;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public String getPictureURL() {
    return pictureURL;
  }

  public void setPictureURL(String pictureURL) {
    this.pictureURL = pictureURL;
  }

  public Set<Movie> getMovies() {
    return movies;
  }

  public void setMovies(Set<Movie> movies) {
    this.movies = movies;
  }
}
