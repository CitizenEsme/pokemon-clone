package com.javaProject.models;

import java.beans.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GameBoard {
	/*
	 *  Functionality: track board, player status
	 */
	
	
	// Fields
	private int levelRows;
	private int levelColumns;
	
	private Player player; 
	private Position playerPosition;
	private ArrayList <Sinkhole> sinkholeList;
	private ArrayList <Collectable> collectables;
	
	private final PropertyChangeSupport pcs;
	private String errorMessage;
	
	
	// Constructor
	public GameBoard(int levelRows, int levelColumns) {
		this.levelRows = levelRows;
		this.levelColumns = levelColumns;
		this.collectables = new ArrayList<>();
		this.sinkholeList = new ArrayList<>();
		
		this.pcs = new PropertyChangeSupport(this);
	}
	
	
	// Observable properties
	public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }
	
	public void move(Player playerToMove, Position newPosition) {
		try {
			this.playerPosition = this.playerPosition.to(newPosition);
//			this.pcs.firePropertyChange("playerPosition", null, this.playerPosition);
			this.pcs.firePropertyChange("gameboard", null, this);
			System.out.println("ok");
		} catch (InvalidMoveException e) {
			this.errorMessage = "Invalid player position change";
            this.pcs.firePropertyChange("errorMessage", "", this.errorMessage);			
		}
	}
	
	public Position getPlayerPosition() {
		return playerPosition;
	}


	// Stores Objects in GameBoard
	public void addPlayer(Player newPlayer, Position playerPosition) {
		this.player = newPlayer;		
		this.playerPosition = playerPosition;
	}
	
	public void addCollectable(Collectable collectable) {
		this.collectables.add(collectable);
	}
	
	public boolean hasPikachuAt(Position positionToCheck) {
		for (Collectable collectable : this.collectables) {
			if (collectable.getPosition().getRow() == positionToCheck.getRow()
					&& collectable.getPosition().getColumn() == positionToCheck.getColumn()
					&& collectable.getCollectableObject() instanceof Pikachu) {
				return true;
			}
		}
		
		return false;
	}

	public void addSinkhole(Sinkhole newSinkhole) {
		sinkholeList.add(newSinkhole);
	}

	
	// Getters
	public Player getPlayer() {
		return player;
	}

	public int getLevelRows() {
		return levelRows;
	}

	public int getLevelColumns() {
		return levelColumns;
	}
	


	public ArrayList<Sinkhole> getSinkholeList() {
		return sinkholeList;
	}
		
	
}
