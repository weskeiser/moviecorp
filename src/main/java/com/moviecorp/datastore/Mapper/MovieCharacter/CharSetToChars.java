package com.moviecorp.datastore.Mapper.MovieCharacter;

import com.moviecorp.datastore.Entity.MovieCharacter;
import com.moviecorp.datastore.Model.MovieCharacter.MovieCharacters;
import java.util.Set;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface CharSetToChars extends Converter<Set<MovieCharacter>, MovieCharacters> {

  @Override
  public default MovieCharacters convert(Set<MovieCharacter> charSet) {

    return new MovieCharacters(charSet);
  }
}
