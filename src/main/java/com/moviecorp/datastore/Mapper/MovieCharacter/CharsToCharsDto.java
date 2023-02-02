package com.moviecorp.datastore.Mapper.MovieCharacter;

import com.moviecorp.datastore.Model.MovieCharacter.MovieCharacters;
import com.moviecorp.datastore.Model.MovieCharacter.MovieCharactersDTO;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface CharsToCharsDto extends Converter<MovieCharacters, MovieCharactersDTO> {}
