package com.javaProject.models;

import java.util.ArrayList;
import java.util.Random;

public class LevelGenerator {
	/*
	 * Functionality: generate board based on level selected
	 */
	
	// Fields
	private int levelRows;
	private int levelColumns;
	private Random random;
	
	private int playerRow;
	private int playerColumn;
	private ArrayList<Integer> playerPosition;
	
	private int pikachus;
	private int pikachuRow;
	private int pikachuColumn;
	private ArrayList<Integer> pikachuPosition;
	
	private int sinkholes;
	private int sinkholeRow;
	private int sinkholeColumn;
	private ArrayList<Integer> sinkholePosition;
	
	// Constructor
	public LevelGenerator() {
	}
	
	
	public GameBoard getGameBoard() {
		GameBoard newGameBoard = new GameBoard(levelRows, levelColumns);
		
		this.random = new Random();
		this.playerPosition = new ArrayList<Integer>();
		this.playerRow = random.nextInt(levelRows);
		this.playerColumn = random.nextInt(levelColumns);
		
		playerPosition.add(playerRow);
		playerPosition.add(playerColumn);
		
		newGameBoard.addPlayer(new Player(playerRow, playerColumn));
		
		for (int p = 0; p < pikachus; p++) {
			this.pikachuPosition = new ArrayList<Integer>();
			this.pikachuRow = random.nextInt(levelRows);
			this.pikachuColumn = random.nextInt(levelColumns);
			
			pikachuPosition.add(pikachuRow);
			pikachuPosition.add(pikachuColumn);
			
			if (pikachuPosition.equals(playerPosition)) {
				System.out.println("Here");
				p=- 1;
			}else {
				newGameBoard.addPikachu(new Pikachu(pikachuRow, pikachuColumn));
			}
		}
		
		for (int s = 0; s < sinkholes; s++) {
			this.sinkholePosition = new ArrayList<Integer>();
			this.sinkholeRow = random.nextInt(levelRows);
			this.sinkholeColumn = random.nextInt(levelColumns);
			
			sinkholePosition.add(sinkholeRow);
			sinkholePosition.add(sinkholeColumn);
			
			if (sinkholePosition.equals(playerPosition) || sinkholePosition.equals(pikachuPosition)) {
				s=- 1;
			}else {
				newGameBoard.addSinkhole(new Sinkhole(sinkholeRow, sinkholeColumn));
			}
		}
		return newGameBoard;
	}
	
	public void setDifficulty(int level) {
		if (level == 1) {
			this.levelRows = 9;
			this.levelColumns = 9;
			this.pikachus = 3;
			this.sinkholes = 2;
			
		}else if (level == 2) {
			this.levelRows = 12;
			this.levelColumns = 12;
			this.pikachus = 4;
			this.sinkholes = 3;
			
		}else if (level == 3) {
			this.levelRows = 15;
			this.levelColumns = 15;
			this.pikachus = 5;
			this.sinkholes = 4;
		}
	}
	
}
