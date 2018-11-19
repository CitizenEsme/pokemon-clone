 package com.javaProject.pokemonClone.entities.creatures;

import com.javaProject.pokemonClone.entities.Entity;

public abstract class Creature extends Entity{
	
	 //Declare variables
	public static final int DEFAULT_ENERGYLEVEL = 100;
	public static final float  DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;
	
	protected int energyLevel;
	protected float speed;
	

	public Creature(int x, int y, int width, int height) {
		super(x, y, width, height);
		energyLevel = DEFAULT_ENERGYLEVEL;
		speed = DEFAULT_SPEED;
	}


	//GETTERS and SETTERS
	public int getEnergyLevel() {
		return energyLevel;
	}


	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}


	public float getSpeed() {
		return speed;
	}


	public void setSpeed(float speed) {
		this.speed = speed;
	}
	

}
