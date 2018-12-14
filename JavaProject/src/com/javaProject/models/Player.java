package com.javaProject.models;


public class Player {
	/*
	 * Functionality: Creates player
	 */
	
	// Fields
	private int energyLevel = 100;
	private int pokemonAmount = 0;
	
	// Constructor
	public Player() {
		
	}
	public Player(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	// Getters
	public int getEnergyLevel() {
		return energyLevel;
	}
	public int getPokemonAmount() {
		return pokemonAmount;
	}
	
	
	// Setters
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
		

}
