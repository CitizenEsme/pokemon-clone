package com.javaProject.pokemonClone.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	//Declare variables
	public static Tile[] tiles = new Tile[256];
	public static Tile blankTile = new BlankTile(0);
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile (BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles [id] = this;
	}
	
	public void tick() {
		
	}
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid() {
		//Dictates that player can walk over tile
		return false;
	}
	public int getId() {
		return id;
	}

}
