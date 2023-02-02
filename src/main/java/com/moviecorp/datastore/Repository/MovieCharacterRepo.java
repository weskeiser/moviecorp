package com.moviecorp.datastore.Repository;

import com.moviecorp.datastore.Entity.MovieCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCharacterRepo extends JpaRepository<MovieCharacter, Long> {}
