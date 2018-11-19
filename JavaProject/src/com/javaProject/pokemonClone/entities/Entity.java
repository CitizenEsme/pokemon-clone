package com.javaProject.pokemonClone.entities;

import java.awt.Graphics;

public abstract class Entity {
	// Declare variables
	public int x, y;
	protected int width, height;
	
	//Constructor
	public Entity (int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	//To update all variables
	public abstract void tick();
	
	//To draw itself to screen
	public abstract void render(Graphics g);

	public int getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	 
}
