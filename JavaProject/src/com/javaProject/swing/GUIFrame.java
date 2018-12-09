package com.javaProject.swing;

import java.awt.*;

import javax.swing.*;

import com.javaProject.models.LevelGenerator;


public class GUIFrame extends JFrame{
	/*
	 * Functionality: Manage two panels that share the same frame 
	 */
	
	// Fields
	 final static String MENUSCREEN = "menuframe";
	 final static String GAMESCREEN = "gameframe";

	 private JPanel cards;
	 private MenuPanel menuPanel;
	 private GamePanel gamePanel;
	 private LevelGenerator generator;
	
	 
	// Constructor
	public GUIFrame(LevelGenerator generator){
		this.generator = generator;
		
		setTitle("Pokemon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cards = new JPanel(new CardLayout());
		getContentPane().add(cards, BorderLayout.CENTER);
		
		menuPanel = new MenuPanel(this, generator);
		cards.add(menuPanel, MENUSCREEN);
		
		pack();
		setVisible(true);
	}
	
	
	public void switchPanels(){
		gamePanel = new GamePanel(generator.getGameBoard());
		cards.add(gamePanel, GAMESCREEN);
		
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, GAMESCREEN);
	}
}
