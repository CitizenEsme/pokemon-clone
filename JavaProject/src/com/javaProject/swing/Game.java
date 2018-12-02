package com.javaProject.swing;

import com.javaProject.models.GameBoard;
import com.javaProject.models.Player;
import com.javaProject.models.PlayerPosition;

public class Game {
	/*
	 * Functionality: Initialize GUI and Game models
	 */
	
	// Constructor
	public Game() {
		// Generate models
		Player player = new Player(0,0);
		GameBoard board = new GameBoard(player);
		
		// Create visuals
		GameFrame gameframe = new GameFrame(board);
//		MenuFrame menuFrame = new MenuFrame();
//		GUIFrame guiFrame = new GUIFrame();
		//GUIFrameTest guiFrameTest = new GUIFrameTest();

	}

}