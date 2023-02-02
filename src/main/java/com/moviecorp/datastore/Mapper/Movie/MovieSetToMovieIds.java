package com.moviecorp.datastore.Mapper.Movie;

import com.moviecorp.datastore.Entity.Movie;
import com.moviecorp.datastore.Model.Movie.MovieId;
import com.moviecorp.datastore.Model.Movie.MovieIds;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface MovieSetToMovieIds extends Converter<Set<Movie>, MovieIds> {

  @Override
  default MovieIds convert(Set<Movie> moviesSet) {

    var movieIds =
        moviesSet.stream().map(m -> new MovieId(m.getMovieId())).collect(Collectors.toSet());

    return new MovieIds(movieIds);
  }
}
