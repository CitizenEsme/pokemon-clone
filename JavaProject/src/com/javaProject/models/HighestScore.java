package com.javaProject.models;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class HighestScore {

	//Fields
	int score = 0;
	int currentScore;
	
	//Constructor
	public HighestScore(Player player) {
		currentScore = player.getPokemonAmount();
	}
	
	public void captureHighestScore(){
		if(currentScore > score){
			score = currentScore;
		}
	}
	

	public int getScore() {
		return score;
	}

	public void writeFile() {

	    try{  // Catch errors in I/O if necessary.
	    // Open a file to write to, named SavedObj.sav.
	    FileOutputStream saveFile=new FileOutputStream("score.txt");

	    // Create an ObjectOutputStream to put objects into save file.
	    ObjectOutputStream save = new ObjectOutputStream(saveFile);

	    // Now we do the save.
	    save.writeObject(score);


	    // Close the file.
	    save.close(); // This also closes saveFile.
	}
	    catch(Exception exc){
	    exc.printStackTrace(); // If there was an error, print the info.
	}
	}

   }
	

