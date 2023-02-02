package com.moviecorp.datastore.Model.Franchise;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FranchisesDTO {

  Set<FranchiseDTO> franchises;
}
