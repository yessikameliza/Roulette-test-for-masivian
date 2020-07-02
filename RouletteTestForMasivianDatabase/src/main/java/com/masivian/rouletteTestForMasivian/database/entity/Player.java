package com.masivian.rouletteTestForMasivian.database.entity;

import java.io.Serializable;

/**
 * @author meliza
 *
 */
public class Player implements Serializable { 
    private static final long serialVersionUID = 1L;
	private String id;
	private int betNumber;
	private String colorSelected;
	private long moneyAmount;
		
	public Player() {
		super();
		
	}
	
	public Player(String id, int betNumber, String colorSelected, long moneyAmount) {
		super();
		this.id = id;
		this.betNumber = betNumber;
		this.colorSelected = colorSelected;
		this.moneyAmount = moneyAmount;
	}	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBetNumber() {
		return betNumber;
	}
	public void setBetNumber(int betNumber) {
		this.betNumber = betNumber;
	}
	public String getColorSelected() {
		return colorSelected;
	}
	public void setColorSelected(String colorSelected) {
		this.colorSelected = colorSelected;
	}
	public long getMoneyAmount() {
		return moneyAmount;
	}
	public void setMoneyAmount(long moneyAmount) {
		this.moneyAmount = moneyAmount;
	}	
}
