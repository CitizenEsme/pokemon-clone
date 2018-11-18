package com.javaProject.pokemonClone;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;


import com.javaProject.pokemonClone.display.Display;


public class Game implements Runnable {
	/*
	 * Implements Runnable to run game in a single thread
	 */
	
	// Declare 
	private Display display;
	public int width, height;
	public String title;
	
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//Constructor
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void init() {
		//Initialize graphics of the game
		display = new Display(title, width, height);
	}
	
	private void tick() {
		//Update all variables, positions of objects
	}
	
	private void render() {
		//Method will draw everything for the game to the screen
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear screen
		g.clearRect(0, 0, width, height);
		
		//Draw Here!
		

		
		//End drawing!
		bs.show();
		g.dispose();
		
	}
	
	public void run() {
		init();
		
		//Start game loop to continuously update and render
		while (running) {
			tick();
			render();
		}
		//Stop thread
		stop();
		
	}
	
	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
