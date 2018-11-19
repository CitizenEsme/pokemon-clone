package com.javaProject.pokemonClone.states;

import java.awt.Graphics;

import com.javaProject.pokemonClone.Game;

public abstract class State {
	/*
	 * Contains all variables and methods applicable for all states
	 */
	
	//Game state manager MOVE TO ANOTHER CLASS
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return  currentState; 
	}
	
	//Declare objects
	protected Game game;
	
	//Constructor
	public State (Game game) {
		this.game = game;
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);

}
