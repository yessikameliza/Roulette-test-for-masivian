package com.masivian.rouletteTestForMasivian.validation;

import com.masivian.rouletteTestForMasivian.entity.Bet;

public class ValidateBetFields {
	public ValidateBetFields() {
		super();
	}

	public boolean validateFields(Bet bet) {
		if (bet.getColorSelected() != null && (bet.getColorSelected().equalsIgnoreCase("Rojo")
				|| bet.getColorSelected().equalsIgnoreCase("Negro"))) {
			return true;
		}
		if (bet.getBetNumber() != null && bet.getBetNumber() >= 0 && bet.getBetNumber() <= 36) {
			return true;
		}

		return false;
	}
}
