package com.javaProject.swing;

import java.awt.GridLayout;
import java.beans.*;
import javax.swing.*;

import com.javaProject.models.GameBoard;
import com.javaProject.models.Player;

public class GamePanel extends JPanel implements PropertyChangeListener{
	/*
	 * Functionality: Create the game screen
	 */
	
	
	// Fields
	private JPanel rightPanel;
	
	private int rows;
	private int columns;
	private JLabel energyLevel;
	private JLabel pokemon;
	private JButton score;
	
//	private BoardTileJToggleButton tile;
	private BoardTile tile;
	private GameBoard board;
	
	
	// Constructor
	public GamePanel(GameBoard board) {
		this.board = board;
		this.rows = board.getLevelRows();
		this.columns = board.getLevelColumns();

		
		JPanel gamePanel = buildGridPanel();
		buildGameGrid(gamePanel);
		add(gamePanel);
		
		
		rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout (3,1));
		energyLevel = new JLabel("Energy Level: " + board.getPlayer().getEnergyLevel());
		rightPanel.add(energyLevel);
		pokemon = new JLabel("Pokemon: " + board.getPlayer().getPokemonAmount());
		rightPanel.add(pokemon);
		
		score = new JButton("Score: " + board.getPlayer().getPokemonAmount());
		rightPanel.add(score);
		
		
		add(rightPanel);
		
		board.addPropertyChangeListener(this);
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
	
	// Event listener
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
