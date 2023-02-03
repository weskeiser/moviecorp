package com.moviecorp.datastore.Service;

import com.moviecorp.datastore.Entity.Franchise;
import com.moviecorp.datastore.Entity.Movie;
import com.moviecorp.datastore.Exception.FranchiseException.FranchiseNotFoundException;
import com.moviecorp.datastore.Model.Franchise.*;
import com.moviecorp.datastore.Model.Movie.MovieIds;
import com.moviecorp.datastore.Model.MovieCharacter.MovieCharacterIds;
import com.moviecorp.datastore.Repository.FranchiseRepo;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class FranchiseService {

  private final FranchiseRepo franchiseRepo;

  @Autowired private ConversionService convertSvc;

  public FranchiseService(FranchiseRepo franchiseRepo) {
    this.franchiseRepo = franchiseRepo;
  }

  public FranchiseDTO save(FranchiseDTO franchiseDTO) {

    var franchise = convert(franchiseDTO, Franchise.class);

    var savedFranchise = franchiseRepo.save(franchise);

    return convert(savedFranchise, FranchiseDTO.class);
  }

  public void delete(Long franchiseId) {
    var franchise = findById(franchiseId);

    franchise.getMovies().forEach(m -> m.setFranchise(null));

    franchiseRepo.delete(franchise);
  }

  private Franchise findById(Long franchiseId) {
    return franchiseRepo
        .findById(franchiseId)
        .orElseThrow(() -> new FranchiseNotFoundException(franchiseId));
  }

  public FranchiseDTO getById(Long franchiseId) {

    var franchise = findById(franchiseId);

    return convert(franchise, FranchiseDTO.class);
  }

  public FranchisesDTO getAll() {

    var franchises = new HashSet<Franchise>(franchiseRepo.findAll());

    return convert(franchises, FranchisesDTO.class);
  }

  public void validateExists(Long franchiseId) {
    if (!franchiseRepo.existsById(franchiseId)) throw new FranchiseNotFoundException(franchiseId);
  }

  // -------------- Characters

  public MovieCharacterIds getAllCharacters(Long franchiseId) {
    var idSet = franchiseRepo.getAllCharacters(franchiseId);

    return convert(idSet, MovieCharacterIds.class);
  }

  // -------------- Movies

  public MovieIds getAllMovies(Long franchiseId) {

    var franchise = findById(franchiseId);

    Set<Movie> movies = franchise.getMovies();

    return convert(movies, MovieIds.class);
  }

  // -------------- Helpers

  private <T> T convert(@Nullable Object source, Class<T> targetType) {
    return convertSvc.convert(source, targetType);
  }
}
