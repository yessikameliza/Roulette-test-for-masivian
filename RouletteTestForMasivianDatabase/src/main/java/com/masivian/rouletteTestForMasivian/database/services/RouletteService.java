package com.masivian.rouletteTestForMasivian.database.services;

import org.springframework.http.ResponseEntity;

import com.masivian.rouletteTestForMasivian.database.entity.Roulette;

public interface RouletteService {
	public ResponseEntity<Long> createRoulette(Roulette roulette); 
	public ResponseEntity<Long> openRoulette(Long rouletteId);
}
