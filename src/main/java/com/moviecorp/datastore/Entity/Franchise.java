package com.moviecorp.datastore.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "franchise")
public class Franchise {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long franchiseId;

  @Column(length = 50)
  @NotEmpty
  private String name;

  private String description;

  @OneToMany(mappedBy = "franchise", orphanRemoval = false)
  private Set<Movie> movies;
}
