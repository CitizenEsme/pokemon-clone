package com.javaProject.models;

public class PlayerPosition {
	/*
	 * DISCONTINUED
	 * Functionality: Contains player position on the board
	 */
	
	// Attributes
	private int row;
	private int column;
	
	// Constructor
	public PlayerPosition(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	public PlayerPosition moveTo(int newRow, int newColumn) throws InvalidMoveException {
		if (isValidPosition(newRow, newColumn)) {
			return (new PlayerPosition(newRow, newColumn));
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
