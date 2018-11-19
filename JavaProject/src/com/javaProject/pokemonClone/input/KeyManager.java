 package com.javaProject.pokemonClone.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	//Declare variables
	private boolean[] keys;
	public boolean up, down, left, right;
	
	//Constructor
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
	}

	@Override
	public void keyTyped(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		System.out.println("Pressed");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyReleased(KeyEvent e) {

		
	}

}
