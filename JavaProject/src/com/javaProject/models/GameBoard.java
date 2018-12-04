package com.javaProject.models;

import java.beans.*;

public class GameBoard{
	/*
	 *  Functionality: track models in GUI and their collisions
	 */
	
	// Fields
	private Player player;
//	private LevelGenerator level;
	
	private final PropertyChangeSupport pcs;
	private String errorMessage;
	
	
	// Constructor
	public GameBoard(Player player) {
		this.player = player;
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
			Player oldPlayer = player;
			player = player.moveTo(row, column);
			this.pcs.firePropertyChange("player", oldPlayer, player);
			
		}catch(InvalidMoveException e) {
			this.errorMessage = "Invalid player position change";
            this.pcs.firePropertyChange("errorMessage", "", this.errorMessage);
		}		
	}

	public Player getPlayer() {
		return player;
	}

//	public LevelGenerator getLevel() {
//		return level;
//	}
}
