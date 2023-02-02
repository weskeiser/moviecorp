package com.moviecorp.datastore.Model.Franchise;

import lombok.Data;

@Data
public class FranchiseUpdate {

  private Long franchiseId;

  private String name;

  private String description;
}
