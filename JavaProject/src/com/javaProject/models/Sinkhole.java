package com.javaProject.models;


public class Sinkhole {
	/*
	 * Functionality: Creates enemy
	 */
	
	// Fields
	private int row;
	private int column;
		
		
	// Constructors
	public Sinkhole(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
}
