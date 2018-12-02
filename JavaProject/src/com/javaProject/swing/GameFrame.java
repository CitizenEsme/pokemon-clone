package com.javaProject.swing;

import java.awt.*;
import java.beans.*;

import javax.swing.*;

import com.javaProject.models.GameBoard;
import com.javaProject.models.Player;


public class GameFrame extends JFrame implements PropertyChangeListener{
	/*
	 * Functionality: Create the display screen for the game
	 */
	
	// Fields
	private int rows;
	private int columns;
	private JPanel rightPanel;
	private JLabel energyLevel;
	private JLabel pokemon;
	private BoardTile tile;
	private GameBoard board;
	
	//Constructor
	public GameFrame(GameBoard board) {
		
		this.rows = 10;
		this.columns = 10;
		this.board = board;
		
		setTitle("Pokemon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLocationRelativeTo(null);
		//setResizable(false);
		getContentPane().setLayout(new GridLayout(1,2));
		
		JPanel gamePanel = buildGridPanel();
		buildGameGrid(gamePanel);
		getContentPane().add(gamePanel);
		
		rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout (2,1));
		
//		energyLevel = new HealthLabel(board);
		energyLevel = new JLabel("Energy Level:" + board.getPlayer().getEnergyLevel());
		rightPanel.add(energyLevel);
		
		pokemon = new JLabel("Pokemon:" + board.getPlayer().getPokemonAmount());
		rightPanel.add(pokemon);
		
		getContentPane().add(rightPanel);
		
		board.addPropertyChangeListener(this);
	
		
		pack();
		setVisible(true);
	}
	
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
	
	private BoardTile buildGameTile(int row, int column) {
		tile = new BoardTile(board, row, column);

		return tile;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName() == "errorMessage") {
			JOptionPane.showMessageDialog(this,
                    evt.getNewValue(),
                    "Error Message",
                    JOptionPane.INFORMATION_MESSAGE);
		}
		if (evt.getPropertyName() == "player") {
			Player updatedPlayer = (Player) evt.getNewValue();
			energyLevel.setText("Energy Level:" + updatedPlayer.getEnergyLevel());
		}
		
	}

}
