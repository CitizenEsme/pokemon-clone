package com.javaProject.models;


public class Player {
	/*
	 * Functionality: Creates player
	 */
	
	// Fields
	private int row;
	private int column;
	private int priorRow;
	private int priorColumn;
	private int energyLevel = 100;
	private int pokemonAmount = 0;
	
	
	// Constructors
	public Player (int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public Player(int row, int column, int energyLevel) {
		this.row = row;
		this.column = column;
		this.energyLevel = energyLevel;
	}
	
	public Player(int row, int column, int energyLevel, int priorRow, int priorColumn) {
		this(row, column, energyLevel);
		this.priorRow = priorRow;
		this.priorColumn = priorColumn;
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
	
	public int getPriorRow() {
		return priorRow;
	}

	public int getPriorColumn() {
		return priorColumn;
	}

	// Player movement
	public Player moveTo(int newRow, int newColumn) throws InvalidMoveException {
		if (isValidPosition(newRow, newColumn)) {
			int newEnergyLevel = energyLevel - 10;
			return (new Player(newRow, newColumn, newEnergyLevel, this.priorRow, this.priorColumn));
		}
		throw new InvalidMoveException();
		
	}
	
	private boolean isValidPosition(int newRow, int newColumn) {
 	
		if (Math.abs(newRow - row) != 1 && Math.abs(newColumn - column) != 1) {
			return false;
		}
		this.priorRow = row;
		this.priorColumn = column;

		return true;
	}
	

}
