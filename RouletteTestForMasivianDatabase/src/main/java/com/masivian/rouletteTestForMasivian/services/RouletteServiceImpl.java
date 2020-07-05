package com.masivian.rouletteTestForMasivian.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.masivian.rouletteTestForMasivian.entity.Bet;
import com.masivian.rouletteTestForMasivian.entity.Roulette;
import com.masivian.rouletteTestForMasivian.repository.RouletteRepository;

public class RouletteServiceImpl implements RouletteService {	
	@Autowired
    private RouletteRepository rouletteRepository;
	
	@Override
	public ResponseEntity<Long> createRoulette(Roulette roulette) {
		try {
			roulette.setStatus(false);
			Roulette newRoulette = rouletteRepository.save(roulette);
			Long rouletteId = newRoulette.getId();			
			return new ResponseEntity<Long>(rouletteId, HttpStatus.OK);
		} catch(Exception e) {			
			return new ResponseEntity<Long>(HttpStatus.BAD_REQUEST);
		}		
	}
	
	@Override
	public ResponseEntity<String> openRoulette(Long rouletteId) {
		try {
			Optional<Roulette> getRoulette = rouletteRepository.findById(rouletteId);
			getRoulette.get().setStatus(true);			
			return new ResponseEntity<String>("Operación exitosa", HttpStatus.OK);
		} catch(Exception e) {			
			return new ResponseEntity<String>("Operación denegada", HttpStatus.BAD_REQUEST);
		}		
	}
	
	@Override
	public Roulette checkRouletteValid(Long rouletteId) {
		Optional<Roulette> getRoulette = rouletteRepository.findById(rouletteId);
		if (getRoulette.isPresent() && getRoulette.get().isStatus()) {
			return getRoulette.get();
		}	
		return null;
	}

	@Override
	public void saveBetInRoulette(Bet bet, Roulette roulette) {
		roulette.getBet().add(bet);
		rouletteRepository.save(roulette);
	}
	
	@Override
	public ResponseEntity<List<Bet>> closeRoulette(Long rouletteId){
		Roulette roulette = checkRouletteValid(rouletteId);
		if(roulette != null) {
			roulette.setStatus(false);
			rouletteRepository.save(roulette);
			return new ResponseEntity<List<Bet>>(roulette.getBet(), HttpStatus.OK);
		}	
		
		return new ResponseEntity<List<Bet>>(HttpStatus.BAD_REQUEST);
	}
	
	@Override
	public ResponseEntity<Iterable<Roulette>> allRoulette(){
		Iterable<Roulette> roulette = rouletteRepository.findAll();
		
		return  new ResponseEntity<Iterable<Roulette>>(roulette, HttpStatus.OK);
	}
}
