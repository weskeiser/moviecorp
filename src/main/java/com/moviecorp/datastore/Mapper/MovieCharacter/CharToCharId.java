package com.moviecorp.datastore.Mapper.MovieCharacter;

import com.moviecorp.datastore.Entity.MovieCharacter;
import com.moviecorp.datastore.Model.MovieCharacter.MovieCharacterId;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface CharToCharId extends Converter<MovieCharacter, MovieCharacterId> {}
