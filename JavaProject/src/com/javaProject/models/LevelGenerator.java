package com.javaProject.models;

public class LevelGenerator {
	/*
	 * Functionality: generate board based on level selected
	 */
	
	// Fields
	private int rows;
	private int columns;
	private int amountOfPokemon;
	private int amountOfSinkholes;
	private int amountOfFood;
	
	// Constructor
	public LevelGenerator(int rows, int columns, int amountOfPokemon, int amountOfSinkholes, int amountOfFood) {
		this.rows = rows;
		this.columns = columns;
		this.amountOfPokemon = amountOfPokemon;
		this.amountOfSinkholes = amountOfSinkholes;
		this.amountOfFood = amountOfFood;
		
	}
}
