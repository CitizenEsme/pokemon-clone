package com.javaProject.models;

public class Position {

	private int row;
	private int column;
	
	public Position() {
		this.row = 0;
		this.column = 0;
	}
	
	public Position(int newRow, int newColumn) {
		this.row = newRow;
		this.column = newColumn;
	}
	
	public Position to(Position newPosition) throws InvalidMoveException {
		if (this.isValidPosition(newPosition.getRow(), newPosition.getColumn())) {
			return newPosition;
		} else {
			throw new InvalidMoveException();
		}
	}
	
	private boolean isValidPosition(int newRow, int newColumn) {
 	
		if (Math.abs(newRow - row) != 1 && Math.abs(newColumn - column) != 1) {
			return false;
		}

		return true;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
}
