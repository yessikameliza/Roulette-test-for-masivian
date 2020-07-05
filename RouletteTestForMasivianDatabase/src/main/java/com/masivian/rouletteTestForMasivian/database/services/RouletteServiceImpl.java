package com.masivian.rouletteTestForMasivian.database.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.masivian.rouletteTestForMasivian.database.entity.Roulette;
import com.masivian.rouletteTestForMasivian.database.repository.RouletteRepository;

public class RouletteServiceImpl implements RouletteService {	
	@Autowired
    private RouletteRepository rouletteRepository;
	
	@Override
	public ResponseEntity<Long> createRoulette(Roulette roulette) {
		try {
			roulette.setStatus(false);
			Roulette newRoulette = rouletteRepository.save(roulette);
			Long rouletteId = newRoulette.getId();			
			return new ResponseEntity<Long>(rouletteId, HttpStatus.ACCEPTED);
		} catch(Exception e) {			
			return new ResponseEntity<Long>(HttpStatus.BAD_REQUEST);
		}		
	}
	
	@Override
	public ResponseEntity<Long> openRoulette(Long rouletteId) {
		try {
			Optional<Roulette> getRoulette = rouletteRepository.findById(rouletteId);
			getRoulette.get().setStatus(true);			
			return new ResponseEntity<Long>(HttpStatus.ACCEPTED);
		} catch(Exception e) {			
			return new ResponseEntity<Long>(HttpStatus.BAD_REQUEST);
		}		
	}	
}
