package com.javaProject.swing;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import com.javaProject.models.GameBoard;


public class StartAction extends AbstractAction {
	/*
	 * DISCONTINUED
	 * Functionality: Start button reacts to click
	 */
	
	
	// Fields
	GUIFrame guiFrame;
	
	
	// Constructor
	public StartAction(String buttonName) {
		super(buttonName);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		board = new GameBoard(board.getPlayer());
//		guiFrame = new GUIFrame(board);
		guiFrame = new GUIFrame (board);
		guiFrame.switchPanels();
	}

}
