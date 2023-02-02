package com.moviecorp.datastore.Mapper.MovieCharacter;

import com.moviecorp.datastore.Model.MovieCharacter.MovieCharacterId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface LongToCharId extends Converter<Long, MovieCharacterId> {

  @Override
  @Mapping(target = "characterId", source = "id")
  MovieCharacterId convert(Long id);
}
