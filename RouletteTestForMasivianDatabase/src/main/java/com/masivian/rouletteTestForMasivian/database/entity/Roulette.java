package com.masivian.rouletteTestForMasivian.database.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Meliza
 */
public class Roulette implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private List<Integer> numbers;
	private String player;
		
	public Roulette() {
		super();
	}

	public Roulette(String id, String name, List<Integer> numbers, String player) {
		super();
		this.id = id;
		this.name = name;
		this.numbers = numbers;
		this.player = player;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getBetNumber() {
		return numbers;
	}
	public void setBetNumber(List<Integer> numbers) {
		this.numbers = numbers;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
}
