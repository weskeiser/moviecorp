package com.moviecorp.datastore.Repository;

import com.moviecorp.datastore.Entity.Franchise;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepo extends JpaRepository<Franchise, Long> {

  @Query(
      value =
          "SELECT c.character_id"
              + " FROM character c"
              + " INNER JOIN character_movie_link cm ON c.character_id = cm.character_id"
              + " INNER JOIN movie m ON cm.movie_id = m.movie_id"
              + " INNER JOIN franchise f ON m.franchise_id = f.franchise_id"
              + " WHERE f.franchise_id = ?1",
      nativeQuery = true)
  Set<Long> getAllCharacters(Long franchiseId);
}
