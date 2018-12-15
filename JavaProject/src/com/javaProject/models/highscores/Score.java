package com.javaProject.models.highscores;

import java.io.Serializable;

public class Score implements Serializable{
	/*
	 * Functionality: Creates Score object
	 */
	
	
	// Field
	private int score;
	
	
	// Constructor
	public Score(int score) {
		this.score = score;
	}

	// Getter
	public int getScore() {
		return score;
	}
}
