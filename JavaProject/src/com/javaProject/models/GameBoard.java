package com.javaProject.models;

import java.beans.*;
import java.util.ArrayList;

public class GameBoard{
	/*
	 *  Functionality: track board, player status
	 */
	
	// Fields
	private int levelRows;
	private int levelColumns;
	
	private Player newPlayer;
//	private Player oldPlayer;
	private ArrayList <Sinkhole> sinkholeList;
	private ArrayList <Pikachu> pikachuList;
	


	private final PropertyChangeSupport pcs;
	private String errorMessage;
	
	
	// Constructor
	public GameBoard(int levelRows, int levelColumns) {
		this.levelRows = levelRows;
		this.levelColumns = levelColumns;
		this.pikachuList = new ArrayList<>();
		this.sinkholeList = new ArrayList<>();
		
		this.pcs = new PropertyChangeSupport(this);
	}
	
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }
	    
//    public void move(MovableInterface somethingOnTheBoard) {
//    	if (this.hasPositionFor(somethingOnTheBoard)) {
//    		return this.getPositionFor(somethingOnTheBoard);
//    	}
//    	
//    	this.setPositionFor(somethingontheboard, new Position());
//    	
//    	return this.getPositionFor(somethingontheboard):
//    }
 
	public void movePlayer(int row, int column) {
		try {
			Player oldPlayer = newPlayer;
//			oldPlayer = newPlayer;
			newPlayer = newPlayer.moveTo(row, column);
			this.pcs.firePropertyChange("player", oldPlayer, newPlayer);
			
		}catch(InvalidMoveException e) {
			this.errorMessage = "Invalid player position change";
            this.pcs.firePropertyChange("errorMessage", "", this.errorMessage);
		}		
	}
	
	public void addPlayer(Player newPlayer) {
		this.newPlayer = newPlayer;		
	}
	
	public void addPikachu(Pikachu newPikachu) {
		pikachuList.add(newPikachu);
	}

	public void addSinkhole(Sinkhole newSinkhole) {
		sinkholeList.add(newSinkhole);
	}
	

	// Getters
	public Player getPlayer() {
		return newPlayer;
	}
	
//	public Player getOldPlayer() {
//		return oldPlayer;
//	}


	public int getLevelRows() {
		return levelRows;
	}

	public int getLevelColumns() {
		return levelColumns;
	}
	
	public ArrayList<Pikachu> getPikachuList() {
		return pikachuList;
	}

	public ArrayList<Sinkhole> getSinkholeList() {
		return sinkholeList;
	}
	
}
