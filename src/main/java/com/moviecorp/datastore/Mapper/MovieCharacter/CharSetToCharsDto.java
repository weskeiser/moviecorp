package com.moviecorp.datastore.Mapper.MovieCharacter;

import com.moviecorp.datastore.Entity.MovieCharacter;
import com.moviecorp.datastore.Model.MovieCharacter.MovieCharacterDTO;
import com.moviecorp.datastore.Model.MovieCharacter.MovieCharactersDTO;
import java.util.Set;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface CharSetToCharsDto extends Converter<Set<MovieCharacter>, MovieCharactersDTO> {

  @Override
  public default MovieCharactersDTO convert(Set<MovieCharacter> charSet) {

    var charDTOSet = charSetToCharDTOset(charSet);

    return new MovieCharactersDTO(charDTOSet);
  }

  Set<MovieCharacterDTO> charSetToCharDTOset(Set<MovieCharacter> source);
}
