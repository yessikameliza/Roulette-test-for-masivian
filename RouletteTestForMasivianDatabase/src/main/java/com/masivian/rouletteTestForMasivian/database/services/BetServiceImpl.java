package com.masivian.rouletteTestForMasivian.database.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.masivian.rouletteTestForMasivian.database.entity.Bet;

@Service
public class BetServiceImpl implements BetService{

	@Override
	public ResponseEntity<HashMap<String, Object>> createBet(Bet bet) {
		HashMap<String, Object> output = new HashMap<String, Object>();
		output.put("mensaje", "este es");
		
		return new ResponseEntity<HashMap<String,Object>>(output, HttpStatus.BAD_REQUEST);
	}

	@Override
	public boolean openBet(Long idRoulette) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Bet> closeBet(Long idRoulette) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> saveBet(Bet bet) {
		// TODO Auto-generated method stub
		return null;
	}

}
