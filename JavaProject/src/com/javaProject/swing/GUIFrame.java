package com.javaProject.swing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.javaProject.models.GameBoard;

public class GUIFrame extends JFrame implements ItemListener{
	/*
	 * Functionality: Create the display screen for the game
	 */
	private final String MENU = "Card with Menu";
	private final String GAME = "Card with Game";
	
	// Fields
	private JPanel cards;
	private JPanel menuCard;
	private JPanel gameCard;
	private JPanel comboBoxPane;
	
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
	
	private int rows;
	private int columns;
	private JPanel rightPanel;
	private JLabel energyLevel;
	private JLabel pokemon;
	private BoardTile tile;
	private GameBoard board;
	
	// Constructor
	public GUIFrame() {
		
		setTitle("Pokemon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponentToPane(getContentPane());
		
		// Display the window
		pack();
		setVisible(true);


	}
	
	public void addComponentToPane(Container pane) {
		comboBoxPane = new JPanel();
		String comboBoxItems[] = {MENU, GAME};
		JComboBox cb = new JComboBox(comboBoxItems);
		cb.setEditable(false);
		cb.addItemListener(this);
		comboBoxPane.add(cb);
		
		
		// Create the Menu card
		menuCard =  new JPanel();
		menuCard.setLayout(new GridLayout(3,1));
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
		

		// Create the Game card
		gameCard = new JPanel();
		this.rows = 10;
		this.columns = 10;
		
		JPanel gamePanel = buildGridPanel();
		buildGameGrid(gamePanel);
		getContentPane().add(gamePanel);
		
		rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout (2,1));
		
		
		// Create the panel that contains the cards
		cards = new JPanel(new CardLayout());
		cards.add(menuCard, MENU);
		cards.add(gameCard, GAME);
		
		pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
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
	
	// Builder methods for Game card
	private JPanel buildGridPanel() {
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(rows, columns));
		
		return gridPanel;	
	}
	
	private void buildGameGrid(JPanel panel) {
		for (int r=0; r < rows; r++) {
			for (int c=0; c < columns; c++) {
				panel.add(buildGameTile(r,c));
			}
		}
	}
	
//	private BoardTile buildGameTile(int row, int column) {
//		tile = new BoardTile(board, row, column);
//
//		return tile;
//		
	private JButton buildGameTile(int row, int column) {
		JButton tile = new JButton();
		tile.setPreferredSize(new Dimension (30,30));
		return tile;
	}
	
	// Builder methods for Menu card
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
		startButton.setPreferredSize(new Dimension(100, 50));
		return startButton;
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		 CardLayout cl = (CardLayout)(cards.getLayout());
		    cl.show(cards, (String)e.getItem());	
	}

}
