package com.javaProject.pokemonClone;


public class Launcher {
	/*
	 * Starts game
	 */
	
	public static void main (String [] args) {
		Game game = new Game("Pokemon", 640, 360);
		game.start();
	}
}
