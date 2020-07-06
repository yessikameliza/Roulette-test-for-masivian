package com.masivian.rouletteTestForMasivian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masivian.rouletteTestForMasivian.entity.Bet;
import com.masivian.rouletteTestForMasivian.entity.Roulette;
import com.masivian.rouletteTestForMasivian.services.BetService;
import com.masivian.rouletteTestForMasivian.services.RouletteService;

@RestController
public class RouletteController {
	@Autowired
	private BetService betService;
	@Autowired
	private RouletteService rouletteService;

	@PostMapping("/create_roulette")
	public ResponseEntity<Long> createRoulette(@RequestBody Roulette roulette) {
		ResponseEntity<Long> rouletteResponse = rouletteService.createRoulette(roulette);

		return rouletteResponse;
	}

	@PutMapping("/open_roulette/{rouletteId}")
	public ResponseEntity<String> openRoulette(@PathVariable Long rouletteId) {
		ResponseEntity<String> rouletteResponse = rouletteService.openRoulette(rouletteId);

		return rouletteResponse;
	}

	@PostMapping("/place_bet")
	public ResponseEntity<String> placeBet(@RequestBody Bet newBet) {
		ResponseEntity<String> bet = betService.newBet(newBet);

		return bet;
	}

	@PutMapping("/close_roulette/{rouletteId}")
	public ResponseEntity<List<Bet>> update(@PathVariable Long rouletteId) {
		ResponseEntity<List<Bet>> response = rouletteService.closeRoulette(rouletteId);

		return response;
	}

	@GetMapping("/roulettes_active_inactive")
	public ResponseEntity<Iterable<Roulette>> allRoulette() {		
		return rouletteService.allRoulette();
	}
}
