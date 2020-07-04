package com.masivian.rouletteTestForMasivian.database.utils;

import com.masivian.rouletteTestForMasivian.database.entity.Bet;

public class ValidateFields {	
	public ValidateFields() {
		super();
	}

	public static boolean validateFields(Bet bet) {
		if (bet.getColorSelected() != null && (bet.getColorSelected().equalsIgnoreCase("Rojo")
				|| bet.getColorSelected().equalsIgnoreCase("Negro"))) {
			return true;
		}		
		if(bet.getBetNumber() != null && bet.getBetNumber() >= 0 && bet.getBetNumber() <= 36) {
			return true;
		}
		
		return false;
	}
}
