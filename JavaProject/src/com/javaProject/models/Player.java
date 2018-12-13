package com.javaProject.models;


public class Player {
	/*
	 * Functionality: Creates player
	 */
	
	// Fields
	private int energyLevel = 100;
	private int pokemonAmount = 0;
	
	
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
	

	// Player movement
//	public Player moveTo(int newRow, int newColumn) throws InvalidMoveException {
//		if (isValidPosition(newRow, newColumn)) {
//			int newEnergyLevel = energyLevel - 10;
//			return (new Player(newRow, newColumn, newEnergyLevel, this.priorRow, this.priorColumn));
//		}
//		throw new InvalidMoveException();
//		
//	}
//	
//
//	private boolean isValidPosition(int newRow, int newColumn) {
// 	
//		if (Math.abs(newRow - row) != 1 && Math.abs(newColumn - column) != 1) {
//			return false;
//		}
//		this.priorRow = row;
//		this.priorColumn = column;
//
//		return true;
//	}
	

}
