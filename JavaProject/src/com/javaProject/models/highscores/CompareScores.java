package com.javaProject.models.highscores;

import java.util.Comparator;

public class CompareScores implements Comparator<Score>{
	/*
	 * Functionality: compares scores
	 */
	
	// Fields
	private int score1;
	private int score2;
	
	// Constructor
	public CompareScores() {	
	}

	@Override
	public int compare(Score score1, Score score2) {
		this.score1 = score1.getScore();
        this.score2 = score2.getScore();

        if (this.score1 > this.score2){
            return -1;
            
        }else if (this.score1 < this.score2){
            return +1;
            
        }else{
        	return 0;
        }
	}

}
