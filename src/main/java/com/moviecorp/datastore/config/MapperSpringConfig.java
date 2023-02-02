package com.moviecorp.datastore.config;

import com.moviecorp.datastore.ConversionServiceAdapter;
import org.mapstruct.MapperConfig;
import org.mapstruct.extensions.spring.SpringMapperConfig;

@MapperConfig(componentModel = "spring", uses = ConversionServiceAdapter.class)
@SpringMapperConfig(
    conversionServiceAdapterPackage = "com.moviecorp.datastore",
    conversionServiceAdapterClassName = "ConversionServiceAdapter"
    // externalConversions = {
    // @ExternalConversion(sourceType = Movie.class, targetType = MovieDTO.class),
    // @ExternalConversion(sourceType = MovieDTO.class, targetType = Movie.class)
    // }
    )
public interface MapperSpringConfig {}
