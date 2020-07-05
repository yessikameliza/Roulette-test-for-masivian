package com.masivian.rouletteTestForMasivian.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.redis.core.index.Indexed;

/**
 * @author Meliza
 */
public class Roulette implements Serializable {
	private static final long serialVersionUID = 1L;
	@Indexed
	private Long id;
	private String name;
	private List<Bet> bet;
	private boolean status;

	public Roulette() {
		super();
	}

	public Roulette(Long id, String name, List<Bet> bet, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.bet = bet;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Bet> getBet() {
		return bet;
	}

	public void setBet(List<Bet> bet) {
		this.bet = bet;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
