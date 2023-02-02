package com.moviecorp.datastore.Mapper.Movie;

import com.moviecorp.datastore.Model.Movie.MovieId;
import com.moviecorp.datastore.Model.Movie.MovieIds;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface LongSetToMovieIds extends Converter<Set<Long>, MovieIds> {

  @Override
  public default MovieIds convert(Set<Long> idSet) {

    var charIds = longsToIds(idSet);

    return new MovieIds(charIds);
  }

  Set<MovieId> longsToIds(Set<Long> ids);

  @Mapping(target = "movieId", source = "id")
  MovieId longToId(Long id);
}
