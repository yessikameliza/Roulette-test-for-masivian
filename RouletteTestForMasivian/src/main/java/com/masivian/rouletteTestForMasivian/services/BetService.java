package com.masivian.rouletteTestForMasivian.services;

import org.springframework.http.ResponseEntity;

import com.masivian.rouletteTestForMasivian.entity.Bet;

public interface BetService {		
	public ResponseEntity<String> newBet(Bet newBet); 
}
