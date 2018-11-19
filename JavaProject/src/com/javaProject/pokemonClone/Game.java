package com.javaProject.pokemonClone;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;


import com.javaProject.pokemonClone.display.Display;
import com.javaProject.pokemonClone.input.KeyManager;
import com.javaProject.pokemonClone.states.GameState;
import com.javaProject.pokemonClone.states.MainMenuState;
import com.javaProject.pokemonClone.states.State;


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
	
	//State
	private State gameState;
	//private State mainMenuState;
	
	//Input
	private KeyManager keyManager;
	
	//Constructor
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	private void init() {
		//Initialize graphics of the game
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		
		gameState = new GameState(this);
		//mainMenuState = new MainMenuState(this);
		State.setState(gameState); 
	}

	private void tick() {
		//Update all variables, positions of objects
		keyManager.tick();
				
		if (State.getState() != null) {
			State.getState().tick();
		}
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
		
		if (State.getState() != null) {
			State.getState().render(g);
		}

		//End drawing!
		bs.show();
		g.dispose();
		
	}
	
	public void run() {
		init();
		//Make the game update and render at similar speeds in slow and fast operating systems
		//frames per second
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		//visual representation of frames per second of the game
		long timer = 0;
		int ticks = 0;
		
		//Start game loop to continuously update and render
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			
			//visual representation of frames per second of the game
			if (timer >= 1000000000) {
				System.out.println("Ticks and Frame: "+ ticks);
				ticks = 0;
				timer = 0;
			}
		}
		//Stop thread
		stop();
		
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
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
