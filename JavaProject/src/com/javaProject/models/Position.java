package com.javaProject.models;

public class Position {

	private int row;
	private int column;
	
	public Position(int newRow, int newColumn) {
		this.row = newRow;
		this.column = newColumn;
	}
	
	public void to(int newRow, int newColumn) {
		this.row = newRow;
		this.column = newColumn;
	}
	
	public void at(int newRow, int newColumn) {
		this.to(newRow, newColumn);
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
}
