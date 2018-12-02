package com.javaProject.swing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MenuFrame extends JFrame{
	/*
	 * Functionality: Create the menu screen for the game
	 */
	
	// Fields
	public boolean gameFrameRunning = false;
	
	private JLabel mainText;
	private JLabel description1;
	private JLabel description2;
	private JLabel description3;
	private JLabel description4;
	private JLabel spinnerTitle;
	private SpinnerNumberModel model1; 
	private JComponent spinner;
	private JButton startButton;
	
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel bottomPanel;
	
	
	
	// Constructor
	public MenuFrame() {
		setTitle("Pokemon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLocationRelativeTo(null);
		getContentPane().setLayout(new GridLayout(3,1));
		
		
		topPanel = buildTopPanel();
		topPanel.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));
		
		middlePanel = buildMiddlePanel();
		middlePanel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		
		bottomPanel = new JPanel();
		bottomPanel.add(buildStartButton());
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		getContentPane().add(topPanel);
		getContentPane().add(middlePanel);
		getContentPane().add(bottomPanel);
		
		pack();
		setVisible(true);
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
		startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameFrameRunning = true;
				System.out.println(gameFrameRunning);
			}
		});
		startButton.setPreferredSize(new Dimension(100, 50));
		return startButton;
	}

	public boolean isGameFrameRunning() {
		return gameFrameRunning;
	}
}

