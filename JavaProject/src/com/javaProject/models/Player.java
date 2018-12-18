package com.javaProject.models;

import java.util.ArrayList;

public class Player {
	/*
	 * Functionality: Creates player
	 */
	
	// Fields
	private int energyLevel = 500;
	private int pokemonAmount = 0;
	
	private ArrayList<Collectable> pikachus;
	
	// Constructor
	public Player() {
		
	}

	
	
	
	
	private void addToCollection(Collectable pikachu) {
		 
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
	public void setPokemonAmount(int pokemonAmount) {
		this.pokemonAmount = pokemonAmount;
	}
}
