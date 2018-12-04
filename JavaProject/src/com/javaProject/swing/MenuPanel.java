package com.javaProject.swing;

import java.awt.*;
import javax.swing.*;


public class MenuPanel extends JPanel{
	/*
	 * Functionality: Create the menu panel 
	 */
	
	// Fields
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel bottomPanel;
	
	private JLabel mainText;
	private JLabel description1;
	private JLabel description2;
	private JLabel description3;
	private JLabel description4;
	
	private JLabel spinnerTitle;
	private SpinnerNumberModel model1; 
	private JComponent spinner;
	
	private JButton startButton;
	
	private StartAction startAction;

	
	// Constructor
	public MenuPanel() {
		setLayout(new GridLayout(3,1));
		
		startAction = new StartAction("Start");
		
		topPanel = buildTopPanel();
		middlePanel = buildMiddlePanel();	
		bottomPanel = new JPanel();
		bottomPanel.add(buildStartButton());
		
		add(topPanel);
		add(middlePanel);
		add(bottomPanel);
	}
	
	
	private JPanel buildTopPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,1));
		
		mainText = new JLabel("Game Description");
		description1 = new JLabel("Try to find all the pokemons");
		description2 = new JLabel("Avoid the sinkhole otherwise the game ends");
		description3 = new JLabel("Move the player by clicking the tiles");
		description4 = new JLabel("Choose a level then click start!");
		
		panel.add(mainText);
		panel.add(description1);
		panel.add(description2);
		panel.add(description3);
		panel.add(description4);
		
		return panel;
	}
	
	private JPanel buildMiddlePanel() {
		JPanel panel = new JPanel();
		
		spinnerTitle = new JLabel("Select Difficulty Level");
		model1 = new SpinnerNumberModel(1, 1, 3, 1); 
		spinner = new JSpinner(model1);
		spinner.setPreferredSize(new Dimension(50, 50));
		
		panel.add(spinnerTitle);
		panel.add(spinner);
		
		return panel;
	}
	
	private JButton buildStartButton() {
		startButton = new JButton(startAction);
		startButton.setPreferredSize(new Dimension(100, 50));
		return startButton;
	}

}