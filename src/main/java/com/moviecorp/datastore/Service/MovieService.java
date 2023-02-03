package com.moviecorp.datastore.Service;

import com.moviecorp.datastore.Entity.Franchise;
import com.moviecorp.datastore.Entity.Movie;
import com.moviecorp.datastore.Exception.MovieException.MovieNotFoundException;
import com.moviecorp.datastore.Model.Franchise.FranchiseDTO;
import com.moviecorp.datastore.Model.Movie.*;
import com.moviecorp.datastore.Model.MovieCharacter.*;
import com.moviecorp.datastore.Repository.MovieRepo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  private final MovieRepo movieRepo;

  @Autowired private ConversionService convertSvc;

  public MovieService(MovieRepo movieRepo) {
    this.movieRepo = movieRepo;
  }

  public MovieDTO save(Movie movie) {

    var savedMovie = movieRepo.save(movie);

    return convert(savedMovie, MovieDTO.class);
  }

  public MovieDTO save(MovieUpdate movieUpdate) {

    var movieToSave = convert(movieUpdate, Movie.class);

    var movieFromDB = findById(movieToSave.getMovieId());

    movieToSave.setFranchise(movieFromDB.getFranchise());
    movieToSave.setMovieCharacters(movieFromDB.getMovieCharacters());

    return save(movieToSave);
  }

  public MovieDTO save(MovieNew movieNew) {

    var movie = convert(movieNew, Movie.class);

    return save(movie);
  }

  public void delete(Long movieId) {
    movieRepo.deleteById(movieId);
  }

  private Movie findById(Long movieId) {
    return movieRepo.findById(movieId).orElseThrow(() -> new MovieNotFoundException(movieId));
  }

  public MovieDTO getById(Long movieId) {

    var movie = findById(movieId);

    return convert(movie, MovieDTO.class);
  }

  public MoviesDTO getAllById(Set<Long> movieIds) {

    var moviesSet = new HashSet<Movie>(movieRepo.findAllById(movieIds));

    return convert(moviesSet, MoviesDTO.class);
  }

  public Set<Movie> findAll() {

    return new HashSet<Movie>(movieRepo.findAll());
  }

  public MoviesDTO getAll() {

    var moviesSet = new HashSet<Movie>(movieRepo.findAll());

    return convert(moviesSet, MoviesDTO.class);
  }

  public void validateExists(Long movieId) {
    if (!movieRepo.existsById(movieId))
      throw new MovieNotFoundException("Movie  not found with the ID: " + movieId);
  }

  // -------------- Franchise

  public void setFranchise(Set<Long> movieIds, FranchiseDTO franchiseDTO) {

    var franchise = convertSvc.convert(franchiseDTO, Franchise.class);

    movieIds.forEach(
        movieId -> {
          var movie = findById(movieId);

          movie.setFranchise(franchise);

          movieRepo.save(movie);
        });
  }

  public void removeFranchise(Long movieId) {

    var movie = findById(movieId);

    movie.setFranchise(null);

    movieRepo.save(movie);
  }

  // -------------- Characters

  public MovieCharactersDTO getAllCharacters(Long movieId) {

    var movie = findById(movieId);

    var charSetInMovie = movie.getMovieCharacters();

    return convert(charSetInMovie, MovieCharactersDTO.class);
  }

  // BUG: Can't add existing
  public MovieCharactersDTO addCharacters(MovieCharactersDTO newMovieCharactersDTO, Long movieId) {

    var movie = findById(movieId);

    MovieCharacters newMovieCharacters = convert(newMovieCharactersDTO, MovieCharacters.class);

    var charSetInMovie = movie.getMovieCharacters();

    charSetInMovie.addAll(newMovieCharacters.getMovieCharacters());

    movie.setMovieCharacters(charSetInMovie);

    movieRepo.save(movie);

    return convert(charSetInMovie, MovieCharactersDTO.class);
  }

  public void removeCharacters(List<Long> charsToRemove, Long movieId) {

    var movie = findById(movieId);

    var charSetInMovie = movie.getMovieCharacters();

    charSetInMovie.removeIf(c -> charsToRemove.contains(c.getCharacterId()));

    movie.setMovieCharacters(charSetInMovie);

    movieRepo.save(movie);
  }

  // --------------

  private <T> T convert(@Nullable Object source, Class<T> targetType) {
    return convertSvc.convert(source, targetType);
  }
}
