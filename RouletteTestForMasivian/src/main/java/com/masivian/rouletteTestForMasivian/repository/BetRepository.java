package com.masivian.rouletteTestForMasivian.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.masivian.rouletteTestForMasivian.entity.Bet;
 
@Repository
public interface BetRepository extends CrudRepository<Bet, Long> {
	
}
 