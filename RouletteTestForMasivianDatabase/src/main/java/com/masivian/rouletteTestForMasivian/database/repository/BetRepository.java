package com.masivian.rouletteTestForMasivian.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.masivian.rouletteTestForMasivian.database.entity.Bet;
 
@Repository
public interface BetRepository extends CrudRepository<Bet, Long> {
}
 