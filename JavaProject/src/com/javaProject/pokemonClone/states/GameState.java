package com.javaProject.pokemonClone.states;

import java.awt.Graphics;

import com.javaProject.pokemonClone.Game;
import com.javaProject.pokemonClone.entities.creatures.Player;

public class GameState extends State{
	/*
	 * State where the game play is at
	 */
	//Declare objects
	private Player player;
	 
	// Constructor
	public GameState(Game game) {
		super(game);
		//player = new Player(game, 100,100);
		
	}
	
	@Override
	public void tick() {
		//player.tick();
		
	}

	@Override
	public void render(Graphics g) {
		//player.render(g);
	}


}
