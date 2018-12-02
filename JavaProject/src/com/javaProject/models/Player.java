
package com.javaProject.models;

public class Player {
	/*
	 * Functionality: Creates player
	 */
	
	// Fields
	private int row;
	private int column;
	private int energyLevel = 100;
	private int pokemonAmount = 0;
	
	
	// Constructors
	public Player(int row, int column) {
		this(row, column, 100);	
	}
	
	public Player(int row, int column, int energyLevel) {
		this.row = row;
		this.column = column;
		this.energyLevel = energyLevel;
	}
	
	//Getters
	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	
	public int getEnergyLevel() {
		return energyLevel;
	}
	public int getPokemonAmount() {
		return pokemonAmount;
	}
	
	// Player movement
	public Player moveTo(int newRow, int newColumn) throws InvalidMoveException {
		if (isValidPosition(newRow, newColumn)) {
			int newEnergyLevel = energyLevel - 10;
			System.out.println(newEnergyLevel);
			return (new Player(newRow, newColumn, newEnergyLevel));
		}
		throw new InvalidMoveException();
		
	}
	
	private boolean isValidPosition(int newRow, int newColumn) {
		if (Math.abs(newRow - row) > 1) {
			return false;
		}else if (Math.abs(newColumn - column) > 1) {
			return false;
		}	
		return true;
	}

}
