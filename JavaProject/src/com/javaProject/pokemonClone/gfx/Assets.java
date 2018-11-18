package com.javaProject.pokemonClone.gfx;

public class Assets {
	/*
	 * Load all assets once
	 */
	//Declare variables
	public static BufferImage player, sinkhole, food, pokemon
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_f_traveler_idle_anim.gif"));
	}

}
