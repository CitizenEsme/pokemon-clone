package com.javaProject.models;

import java.beans.*;
import java.util.ArrayList;

public class GameBoard {
	/*
	 *  Functionality: track board objects
	 */
	
	
	// Fields
	private int levelRows;
	private int levelColumns;
	
	private Player player; 
	private Position playerPosition;
	private ArrayList <Opponent> opponents;
	private ArrayList <Collectable> collectables;
	
	private final PropertyChangeSupport pcs;
	private String errorMessage;
	private String gameoverMessage;
	private String steppedInSinkhole;
	
	
	// Constructor
	public GameBoard(int levelRows, int levelColumns) {
		this.levelRows = levelRows;
		this.levelColumns = levelColumns;
		this.collectables = new ArrayList<>();
		this.opponents = new ArrayList<>();
		
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
			int oldEnergyLevel = this.player.getEnergyLevel();
			int oldPokemonAmount = this.player.getPokemonAmount();
			
			if (hasPikachuAt(newPosition)) {
				this.player.setPokemonAmount(oldPokemonAmount+1);
				int newPokemonAmount = this.player.getPokemonAmount();
				
				this.pcs.firePropertyChange("pokemonAmount", oldPokemonAmount, newPokemonAmount);
//				this.pcs.firePropertyChange("pokemonClicked", null, newPosition);
			}else if(hasSinkholeAt(newPosition)) {
				this.steppedInSinkhole = "Stepped in sinkhole and fell to your dead.";
				this.pcs.firePropertyChange("Sinkhole", "", this.steppedInSinkhole);
				
			}else {
				this.playerPosition = this.playerPosition.to(newPosition);
				this.player.setEnergyLevel(oldEnergyLevel-10);
			}
			int newEnergyLevel = this.player.getEnergyLevel();
			
			this.pcs.firePropertyChange("playerPosition", null, this.playerPosition);
//			this.pcs.firePropertyChange("gameboard", null, this);
			
			if (newEnergyLevel <= 0) {
				this.gameoverMessage = "Game Over";
				this.pcs.firePropertyChange("GameOver", "", this.gameoverMessage);
			}else {
				this.pcs.firePropertyChange("energyLevel", oldEnergyLevel, newEnergyLevel);
			}
		
		} catch (InvalidMoveException e) {
			this.errorMessage = "Invalid player position change";
            this.pcs.firePropertyChange("errorMessage", "", this.errorMessage);			
		}
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
	
	public void addOpponent(Opponent opponent) {
		this.opponents.add(opponent);
	}
	public boolean hasSinkholeAt(Position positionToCheck) {
		for (Opponent opponent : this.opponents) {
			if(opponent.getPosition().getRow() == positionToCheck.getRow()
					&& opponent.getPosition().getColumn() == positionToCheck.getColumn()
					&& opponent.getOpponentObject() instanceof Sinkhole) {
				return true;
			}
		}
		return false;
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
	public Position getPlayerPosition() {
		return playerPosition;
	}
}