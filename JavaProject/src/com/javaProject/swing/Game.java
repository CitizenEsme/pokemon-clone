package com.javaProject.swing;

import com.javaProject.models.LevelGenerator;


public class Game {
	/*
	 * Functionality: Initialize GUI and Game model
	 */
	
	
	// Constructor
	public Game() {
		// Generate model
		LevelGenerator generator = new LevelGenerator();
		
		
		// Create visuals
		GUIFrame guiFrame = new GUIFrame(generator);
	}
}
