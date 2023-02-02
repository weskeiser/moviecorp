package com.moviecorp.datastore.Mapper.MovieCharacter;

import com.moviecorp.datastore.Model.MovieCharacter.*;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface LongSetToCharIds extends Converter<Set<Long>, MovieCharacterIds> {

  @Override
  public default MovieCharacterIds convert(Set<Long> idSet) {

    var charIds = longsToIds(idSet);

    return new MovieCharacterIds(charIds);
  }

  Set<MovieCharacterId> longsToIds(Set<Long> ids);

  @Mapping(target = "characterId", source = "id")
  MovieCharacterId longToId(Long id);
}
