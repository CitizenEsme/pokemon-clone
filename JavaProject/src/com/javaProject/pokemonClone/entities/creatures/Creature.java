 package com.javaProject.pokemonClone.entities.creatures;

import com.javaProject.pokemonClone.entities.Entity;

public abstract class Creature extends Entity{
	
	 //Declare variables
	protected int energyLevel;

	public Creature(float x, float y) {
		super(x, y);
		energyLevel = 100;
		
	}
	

}
