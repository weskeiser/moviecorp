package com.moviecorp.datastore.Mapper.Franchise;

import com.moviecorp.datastore.Entity.Franchise;
import com.moviecorp.datastore.Model.Franchise.*;
import java.util.Set;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface FranSetToFransDto extends Converter<Set<Franchise>, FranchisesDTO> {

  @Override
  public default FranchisesDTO convert(Set<Franchise> franchisesSet) {

    var franchisesDTOset = FranSetToFranDtoSet(franchisesSet);

    return new FranchisesDTO(franchisesDTOset);
  }

  Set<FranchiseDTO> FranSetToFranDtoSet(Set<Franchise> source);
}
