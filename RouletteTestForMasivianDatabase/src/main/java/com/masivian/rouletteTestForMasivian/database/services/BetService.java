package com.masivian.rouletteTestForMasivian.database.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.masivian.rouletteTestForMasivian.database.entity.Bet;

public interface BetService {		
	public ResponseEntity<HashMap<String, Object>> createBet(Bet bet);	
	public boolean openBet(Long idRoulette);
	public List<Bet> closeBet(Long idRoulette);
	public ResponseEntity<HashMap<String, Object>> saveBet(Bet bet);
}
