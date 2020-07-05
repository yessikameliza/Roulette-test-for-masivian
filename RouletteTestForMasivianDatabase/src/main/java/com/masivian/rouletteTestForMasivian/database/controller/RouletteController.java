package com.masivian.rouletteTestForMasivian.database.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masivian.rouletteTestForMasivian.database.entity.Bet;
import com.masivian.rouletteTestForMasivian.database.entity.Roulette;
import com.masivian.rouletteTestForMasivian.database.repository.RouletteRepository;
import com.masivian.rouletteTestForMasivian.database.services.BetService;
import com.masivian.rouletteTestForMasivian.database.services.RouletteService;
import com.masivian.rouletteTestForMasivian.database.validation.ValidateBetFields;

@RestController
@CrossOrigin
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

	@PutMapping("/open_roulette/")
	public ResponseEntity<Long> openRoulette(@RequestParam("id") Long rouletteId) {
		ResponseEntity<Long> rouletteResponse = rouletteService.openRoulette(rouletteId);

		return rouletteResponse;
	}

	@PostMapping("/place_bet")
	public ResponseEntity<String> placeBet(@RequestBody Bet newBet) {
		ResponseEntity<String> bet = betService.newBet(newBet);

		return bet;
	}

	@PutMapping("")
	public ResponseEntity<List<Bet>> update(@RequestParam("id") Long rouletteId) {
		ResponseEntity<List<Bet>> response = rouletteService.closeRoulette(rouletteId);

		return response;
	}

	@DeleteMapping("/{id}")
	public String deleteroulette(@PathVariable String id) {
		rouletteRepository.delete(id);

		return id;
	}
}
