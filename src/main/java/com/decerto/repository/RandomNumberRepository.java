package com.decerto.repository;

import com.decerto.model.RandomNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RandomNumberRepository extends JpaRepository<RandomNumber, Integer> {

    @Query(nativeQuery = true, value = "select random_number from random_number order by RAND() limit 1")
    int findRandom();
}
