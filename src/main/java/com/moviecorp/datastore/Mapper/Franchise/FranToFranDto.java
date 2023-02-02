package com.moviecorp.datastore.Mapper.Franchise;

import com.moviecorp.datastore.Entity.Franchise;
import com.moviecorp.datastore.Model.Franchise.FranchiseDTO;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface FranToFranDto extends Converter<Franchise, FranchiseDTO> {}
