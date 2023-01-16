package com.moviecorp.datastore.Repository;

import com.moviecorp.datastore.Entity.MovieCharacter;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCharacterRepo extends CrudRepository<MovieCharacter, Long> {}
