package com.masivian.rouletteTestForMasivian.entity;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

/**
 * @author meliza *
 */
@RedisHash("Bet")
public class Bet {
	@Indexed
	private Long id;
	private Long betNumber;
	private String colorSelected;
	private Long moneyAmount;
	private Long roulette;
	private String player;

	public Bet() {
		super();
	}

	public Bet(Long id, Long betNumber, String colorSelected, Long moneyAmount) {
		super();
		this.id = id;
		this.betNumber = betNumber;
		this.colorSelected = colorSelected;
		this.moneyAmount = moneyAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBetNumber() {
		return betNumber;
	}

	public void setBetNumber(Long betNumber) {
		this.betNumber = betNumber;
	}

	public String getColorSelected() {
		return colorSelected;
	}

	public void setColorSelected(String colorSelected) {
		this.colorSelected = colorSelected;
	}

	public Long getMoneyAmount() {
		return moneyAmount;
	}

	public void setMoneyAmount(Long moneyAmount) {
		this.moneyAmount = moneyAmount;
	}

	public Long getRoulette() {
		return roulette;
	}

	public void setRoulette(Long roulette) {
		this.roulette = roulette;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
}
