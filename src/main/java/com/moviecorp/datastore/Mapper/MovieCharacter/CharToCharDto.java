package com.moviecorp.datastore.Mapper.MovieCharacter;

import com.moviecorp.datastore.Entity.MovieCharacter;
import com.moviecorp.datastore.Model.MovieCharacter.MovieCharacterDTO;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface CharToCharDto extends Converter<MovieCharacter, MovieCharacterDTO> {}
