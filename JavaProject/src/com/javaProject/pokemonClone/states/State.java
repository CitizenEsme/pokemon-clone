package com.javaProject.pokemonClone.states;

import java.awt.Graphics;

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
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

}
