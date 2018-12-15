package com.javaProject.swing;

import java.awt.GridLayout;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

import com.javaProject.models.GameBoard;
import com.javaProject.models.Player;
import com.javaProject.models.highscores.HighScoreManager;
import com.javaProject.models.highscores.Score;

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
	private JButton highScores;
	
	private BoardTile tile;
	private GameBoard board;
	private Score score;
	private HighScoreManager highScoreManager;
	private GUIFrame guiFrame;
	
	
	// Constructor
	public GamePanel(GUIFrame guiFrame, GameBoard board) {
		this.board = board;
		this.rows = board.getLevelRows();
		this.columns = board.getLevelColumns();
		this.guiFrame = guiFrame;

		
		JPanel gamePanel = buildGridPanel();
		buildGameGrid(gamePanel);
		add(gamePanel);
		
		
		rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout (3,1));
		energyLevel = new JLabel("Energy Level: " + board.getPlayer().getEnergyLevel());
		rightPanel.add(energyLevel);
		pokemon = new JLabel("Pokemon: " + board.getPlayer().getPokemonAmount());
		rightPanel.add(pokemon);
		
		rightPanel.add(buildHighScoreButton());
		
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
	
	private JButton buildHighScoreButton () {
		this.highScores = new JButton("High Scores");
		this.highScoreManager = new HighScoreManager();
		highScoreManager.addScore(board.getPlayer().getPokemonAmount());
		
		
		highScores.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(
						null,
                        highScoreManager.getHighscoreString());
			}	
		});
		return highScores;
	}
	
	
	// Event listeners
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName() == "errorMessage") {
			JOptionPane.showMessageDialog(
					this,
                    evt.getNewValue(),
                    "Error Message",
                    JOptionPane.INFORMATION_MESSAGE);
		}
		if (evt.getPropertyName() == "energyLevel") {
			int updatedEnergyLevel = (int) evt.getNewValue();
			this.energyLevel.setText("Energy Level:" + updatedEnergyLevel);
		}
		if (evt.getPropertyName() == "pokemonAmount") {
			int updatedPokemonAmount = (int) evt.getNewValue();
			this.pokemon.setText("Pokemon:" + updatedPokemonAmount);
		}
		if (evt.getPropertyName() == "GameOver") {
			JOptionPane.showMessageDialog(
					this,
                    evt.getNewValue(),
                    "Game Over",
                    JOptionPane.INFORMATION_MESSAGE);
			this.highScoreManager.addScore(board.getPlayer().getPokemonAmount());
			this.guiFrame.endGame();
		}
		if (evt.getPropertyName() == "Sinkhole") {
			JOptionPane.showMessageDialog(
					this,
                    evt.getNewValue(),
                    "Stepped in sinkhole and fell to your dead.",
                    JOptionPane.INFORMATION_MESSAGE);
			this.highScoreManager.addScore(board.getPlayer().getPokemonAmount());
			this.guiFrame.endGame();
		}

	}
}
