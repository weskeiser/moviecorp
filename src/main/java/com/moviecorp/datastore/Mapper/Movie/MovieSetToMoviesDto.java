package com.moviecorp.datastore.Mapper.Movie;

import com.moviecorp.datastore.Entity.Movie;
import com.moviecorp.datastore.Model.Movie.MovieDTO;
import com.moviecorp.datastore.Model.Movie.Movies;
import com.moviecorp.datastore.Model.Movie.MoviesDTO;
import java.util.Set;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface MovieSetToMoviesDto extends Converter<Set<Movie>, MoviesDTO> {

  @Override
  public default MoviesDTO convert(Set<Movie> moviesSet) {

    var movies = new Movies(moviesSet);

    return moviesToMoviesDTO(movies);
  }

  public MoviesDTO moviesToMoviesDTO(Movies movies);

  @AfterMapping
  default MovieDTO toSubClassDTO(Movie entity, @MappingTarget MovieDTO dto) {

    var movieToMovieDto = Mappers.getMapper(MovieToMovieDto.class);

    if (entity instanceof Movie) {
      return movieToMovieDto.convert(entity);
    }

    return dto;
  }
}
