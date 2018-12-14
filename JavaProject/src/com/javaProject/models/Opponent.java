package com.javaProject.models;

public class Opponent {
	/*
	 * Functionality:
	 */
	
	
	// Fields
	private Position position;
	private OpponentInterface opponentObject;
	
	
	
	// Constructor
	public Opponent(Position position, OpponentInterface opponentObject) {
		this.position = position;
		this.opponentObject = opponentObject;	
	}
	
	// Getters
	public Position getPosition() {
		return this.position;
	}
	public OpponentInterface getOpponentObject() {
		return this.opponentObject;
	}

}
