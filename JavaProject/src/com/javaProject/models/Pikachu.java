package com.javaProject.models;


public class Pikachu {
	/*
	 * Functionality: Creates enemy
	 */
	
	// Fields
	private int row;
	private int column;
		
		
	// Constructors
	public Pikachu(int row, int column) {
		this.row = row;
		this.column = column;
	}

	// Getters
	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
}
