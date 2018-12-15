package com.javaProject.models.highscores;

import java.io.*;
import java.util.*;

public class HighScoreManager {
	/*
	 * Functionality: Adds, stores, sorts (manages) scores
	 */
	
	
	// Fields
	private ArrayList<Score> scores;
	private static final String HIGHSCORE_FILE = "topscores.txt";
	
	ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;
    
    
	// Constructor
	public HighScoreManager() {
		this.scores = new ArrayList<>();
	}
	
	
	private ArrayList<Score> getScores(){
		loadScoreFile();
        sort();
		return scores;
	}
	
	private void sort() {
		CompareScores comparator = new CompareScores();
        Collections.sort(scores, comparator);
	}
	
	public void addScore(int score) {
		loadScoreFile();
		if (score>0) {
			scores.add(new Score(score));
		}
        updateScoreFile();
	}
	
	private void loadScoreFile() {
		try {
			inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            scores = (ArrayList<Score>)inputStream.readObject();
            
		} catch (FileNotFoundException e) {
            System.out.println("FNF Error: " + e.getMessage());
            
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
            
        } catch (ClassNotFoundException e) {
            System.out.println("CNF Error: " + e.getMessage());
            
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("IO Error: " + e.getMessage());
            }
        }
	}
	
	private void updateScoreFile() {
		try {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(scores);
            
        } catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
            
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
            
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
	}
	
	public String getHighscoreString() {
		String highscoreString = "";
		final int max = 10;

		ArrayList<Score> scores;
		scores = getScores();
	
		int i = 0;
		int scoresListLenght = scores.size();
		if (scoresListLenght > max) {
			scoresListLenght = max;
		}
		
		while (i < scoresListLenght) {
			highscoreString += (i + 1) + ".\t" + scores.get(i).getScore() + "\n";
		    i++;
		}
		
		return highscoreString;
	}

}
