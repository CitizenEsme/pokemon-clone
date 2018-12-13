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
	
	private Player player; 
	private Position playerPosition;
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
	
	
	// Observable properties
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
			Player oldPlayer = player;
//			oldPlayer = newPlayer;
			player = player.moveTo(row, column);
			this.pcs.firePropertyChange("player", oldPlayer, player);
			
		}catch(InvalidMoveException e) {
			this.errorMessage = "Invalid player position change";
            this.pcs.firePropertyChange("errorMessage", "", this.errorMessage);
		}		
	}
	
	// Stores Objects in GameBoard
	public Position addPlayer(Player newPlayer) {
		this.player = newPlayer;		
		this.playerPosition = new Position(0, 0);
		
		return this.playerPosition;
	}
	
	public void addPikachu(Pikachu newPikachu) {
		pikachuList.add(newPikachu);
	}

	public void addSinkhole(Sinkhole newSinkhole) {
		sinkholeList.add(newSinkhole);
	}
	
	// Player movement
//	public void move(Player player) {
//		newPlayer;	
//	}
	public void moveto(int newRow, int newColumn) throws InvalidMoveException{
		if (isValidPosition(newRow, newColumn)) {
			int oldEnergyLevel = player.getEnergyLevel();
			player.setEnergyLevel(oldEnergyLevel-10);
			player.setRow(newRow);
			player.setColumn(newColumn);
		}else {
			throw new InvalidMoveException();
		}	
	}
	
	public void firePlayerMovement () {
		try {
			Player oldPlayer = player;
//			oldPlayer = newPlayer;
//			newPlayer = newPlayer;
			this.pcs.firePropertyChange("player", oldPlayer, player);

		}catch(InvalidMoveException e) {
			this.errorMessage = "Invalid player position change";
            this.pcs.firePropertyChange("errorMessage", "", this.errorMessage);
		}
	}
	private boolean isValidPosition(int newRow, int newColumn) {
		if (Math.abs(newRow - player.getRow()) != 1 && Math.abs(newColumn - player.getColumn()) != 1) {
			return false;
		}
		return true;
	}
//	public Player moveTo(int newRow, int newColumn) throws InvalidMoveException {
//		if (isValidPosition(newRow, newColumn)) {
//			int newEnergyLevel = energyLevel - 10;
//			return (new Player(newRow, newColumn, newEnergyLevel, this.priorRow, this.priorColumn));
//		}
//		throw new InvalidMoveException();	
//	}

	
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
	
	public ArrayList<Pikachu> getPikachuList() {
		return pikachuList;
	}

	public ArrayList<Sinkhole> getSinkholeList() {
		return sinkholeList;
	}
	
}
