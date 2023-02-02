package com.moviecorp.datastore.Mapper.Movie;

import com.moviecorp.datastore.Entity.Movie;
import com.moviecorp.datastore.Model.Movie.MovieUpdate;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface MovieUpdateToMovie extends Converter<MovieUpdate, Movie> {}
