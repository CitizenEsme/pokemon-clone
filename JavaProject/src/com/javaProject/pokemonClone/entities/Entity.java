package com.javaProject.pokemonClone.entities;

import java.awt.Graphics;

public abstract class Entity {
	// Declare variables
	protected float x, y;
	
	//Constructor
	public Entity (float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	//To update all variables
	public abstract void tick();
	
	//To draw itself to screen
	public abstract void render(Graphics g);
}
