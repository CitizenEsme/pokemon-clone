package com.javaProject.swing;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.javaProject.models.GameBoard;
import com.javaProject.models.Player;

public class StartAction extends AbstractAction {
	/*
	 * Functionality: Start button reacts to click
	 */
	// Fields
	GUIFrame guiFrame;
	GameBoard board;
	Player player;
	
	// Constructor
	public StartAction(String buttonName) {
		super(buttonName);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player = new Player(0,0);
		board = new GameBoard(player);
		guiFrame = new GUIFrame(board);
		guiFrame.switchPanels();
	}

}
