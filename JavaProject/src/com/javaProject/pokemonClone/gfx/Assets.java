package com.javaProject.pokemonClone.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	/*
	 * Load all assets once
	 * works with a spritesheet to load all images at once
	 */
	
	//Declare variables
	public static BufferedImage player, sinkhole, food, pokemon
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_f_traveler_idle_anim.gif"));
	}

}
