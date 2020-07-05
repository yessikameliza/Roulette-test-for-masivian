package com.masivian.rouletteTestForMasivian.database.services;

import org.springframework.http.ResponseEntity;

import com.masivian.rouletteTestForMasivian.database.entity.Bet;

public interface BetService {		
	public ResponseEntity<String> newBet(Bet newBet); 
}
