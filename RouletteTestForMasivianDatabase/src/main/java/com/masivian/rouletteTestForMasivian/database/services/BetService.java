package com.masivian.rouletteTestForMasivian.database.services;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;

import com.masivian.rouletteTestForMasivian.database.entity.Bet;

public interface BetService {		
	public ResponseEntity<String> newBet(Bet newBet); 
}
