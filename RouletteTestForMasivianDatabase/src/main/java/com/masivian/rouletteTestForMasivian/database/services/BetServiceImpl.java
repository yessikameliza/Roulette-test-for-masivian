package com.masivian.rouletteTestForMasivian.database.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.masivian.rouletteTestForMasivian.database.entity.Bet;
import com.masivian.rouletteTestForMasivian.database.entity.Roulette;
import com.masivian.rouletteTestForMasivian.database.repository.BetRepository;
import com.masivian.rouletteTestForMasivian.database.utils.ValidateBetFields;

@Service
public class BetServiceImpl implements BetService {
	@Autowired
	private BetRepository betRepository;
	@Autowired
	private RouletteService rouletteService;
	@Autowired
	private HttpServletRequest requestHeaders;
	private ValidateBetFields validateBetFields;

	@Override
	public ResponseEntity<String> newBet(Bet bet) {
		Roulette checkRouletteValid = rouletteService.checkRouletteValid(bet.getRoulette());
		boolean isValid = validateBetFields.validateFields(bet);
		bet.setPlayer(requestHeaders.getHeader("user"));
		Long amount = bet.getMoneyAmount();
		if (checkRouletteValid != null && amount != null
				&& isValid && checkRouletteValid.isStatus() && amount <= 10000) {
			betRepository.save(bet);
			rouletteService.saveBetInRoulette(bet, checkRouletteValid);
			return new ResponseEntity<String>("La apuesta fue realizada con éxito", HttpStatus.OK);
		}

		return new ResponseEntity<String>("La apuesta fue rechada", HttpStatus.BAD_REQUEST);
	}
}
