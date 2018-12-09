package com.javaProject.models;

import java.beans.*;

public class GameBoard{
	/*
	 *  Functionality: track board, player status
	 */
	
	// Fields
	private int levelRows;
	private int levelColumns;
	
	private Player newPlayer;
	private Sinkhole newSinkhole;
	private Pikachu newPikachu;

	private final PropertyChangeSupport pcs;
	private String errorMessage;
	
	
	// Constructor
	public GameBoard(int levelRows, int levelColumns) {
		this.levelRows = levelRows;
		this.levelColumns = levelColumns;
		
		this.pcs = new PropertyChangeSupport(this);
	}
	
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }
	    
 
	public void movePlayer(int row, int column) {
		try {
			Player oldPlayer = newPlayer;
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
		this.newPikachu = newPikachu;
	}
	
	public void addSinkhole(Sinkhole newSinkhole) {
		this.newSinkhole = newSinkhole;
	}
	

	// Getters
	public Player getPlayer() {
		return newPlayer;
	}

	public Sinkhole getSinkHole() {
		return newSinkhole;
	}

	public Pikachu getPikachu() {
		return newPikachu;
	}

	public int getLevelRows() {
		return levelRows;
	}

	public int getLevelColumns() {
		return levelColumns;
	}
	
}
