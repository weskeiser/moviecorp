package com.moviecorp.datastore.Mapper.Movie;

import com.moviecorp.datastore.Entity.Movie;
import com.moviecorp.datastore.Model.Movie.MovieDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface MovieToMovieDto extends Converter<Movie, MovieDTO> {

  @Mapping(target = "franchiseId", source = "movie.franchise.franchiseId")
  @Override
  public MovieDTO convert(Movie movie);
}
