package com.masivian.rouletteTestForMasivian.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.masivian.rouletteTestForMasivian.entity.Roulette;

@Repository
public interface RouletteRepository extends CrudRepository<Roulette, Long> {

}
