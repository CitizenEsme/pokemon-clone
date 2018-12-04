package com.javaProject.swing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.javaProject.models.GameBoard;


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
	
	// Constructor
	public GUIFrame(GameBoard board) {
		
		setTitle("Pokemon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cards = new JPanel(new CardLayout());
		getContentPane().add(cards, BorderLayout.CENTER);
		
		menuPanel = new MenuPanel(this, board);
		gamePanel = new GamePanel(board);
		
		cards.add(menuPanel, MENUSCREEN);
		cards.add(gamePanel, GAMESCREEN);
		
		
		pack();
		setVisible(true);
		
	}
	
	public void switchPanels() {
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, GAMESCREEN);
	}

}
