package com.masivian.rouletteTestForMasivian.validation;

import com.masivian.rouletteTestForMasivian.entity.Bet;

public class ValidateBetFields {
	public ValidateBetFields() {
		super();
	}

	public static boolean validateFields(Bet bet) {
		if (bet.getColorSelected() != null && (bet.getColorSelected().equalsIgnoreCase("rojo")
				|| bet.getColorSelected().equalsIgnoreCase("negro"))) {
			return true;
		}
		if (bet.getBetNumber() != null && bet.getBetNumber() >= 0 && bet.getBetNumber() <= 36) {
			return true;
		}

		return false;
	}
}
