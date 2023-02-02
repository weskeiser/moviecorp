package com.moviecorp.datastore.Entity;

import com.moviecorp.datastore.Enum.Gender;
import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "character")
public class MovieCharacter {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long characterId;

  @Column(nullable = false, length = 100)
  private String fullName;

  @Column(length = 50)
  private String alias;

  @Column(nullable = false, length = 6)
  @Enumerated(EnumType.STRING)
  private Gender gender;

  @Column private String pictureUrl;

  @ManyToMany(
      cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
  @JoinTable(
      name = "character_movie_link",
      joinColumns = {@JoinColumn(name = "character_id")},
      inverseJoinColumns = {@JoinColumn(name = "movie_id")})
  private List<Movie> movies;
}
