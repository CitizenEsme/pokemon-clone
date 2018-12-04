package com.javaProject.swing;

import java.util.Random;

import com.javaProject.models.GameBoard;
import com.javaProject.models.Player;
import com.javaProject.models.PlayerPosition;

public class Game {
	/*
	 * Functionality: Initialize GUI and Game models
	 */
	
	
	// Fields
	private Random random;
	private int row;
	private int column;
	
	
	// Constructor
	public Game() {
		// Game Logic
		random = new Random();
		row = random.nextInt(9);
		column = random.nextInt(9);
		
		// Generate models
		Player player = new Player(row,column);
		GameBoard board = new GameBoard(player);
		
		// Create visuals
		GUIFrame guiFrame = new GUIFrame(board);

	}

}
