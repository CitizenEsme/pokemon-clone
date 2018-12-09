package com.javaProject.swing;

import java.awt.*;
import java.beans.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import com.javaProject.models.GameBoard;
import com.javaProject.models.Pikachu;
import com.javaProject.models.Player;
import com.javaProject.models.Sinkhole;


public class BoardTile extends JButton implements PropertyChangeListener{
	/*
	 * Functionality: Creates a board tile
	 */

	// Fields
	private int row;
	private int column;
	private boolean playerInvalidPosition = false;

	
	// Constructor
	public BoardTile(GameBoard board, int row, int column){
		super(new MoveAction(board, row, column));
		this.row = row;
		this.column = column;

		setPreferredSize(new Dimension(30,30));
		
		board.addPropertyChangeListener(this);	
		
		this.renderWithPlayer(board.getPlayer());
		this.renderWithNoneMovingObjects(board.getPikachu(), board.getSinkHole());
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		switch (evt.getPropertyName()) {
			case "player":
				renderWithPlayer((Player) evt.getNewValue());
				break;
		}
	}
	
	private void renderWithPlayer (Player newPosition) {
		if (newPosition.getRow() == row && newPosition.getColumn() == column) {
			if (playerInvalidPosition == false) {
				try {
				    Image img = ImageIO.read(getClass().getResource("/30x30player.png"));
				    setIcon(new ImageIcon(img));
				    setBorderPainted(false);
				}catch (Exception ex) {
				    System.out.println(ex);
				}
			}
		}else if (isTileVisible(newPosition)){
//			setIcon(null);
//			setOpaque(true);
//			setBorderPainted(true);
		}else {
//			setIcon(null);
//			setBackground(Color.DARK_GRAY);
//			setOpaque(true);
//			setBorderPainted(false);

		}
	}
	
	private void renderWithNoneMovingObjects(Pikachu pikachuPosition, Sinkhole sinkholePosition) {
		if (pikachuPosition.getRow() == row && pikachuPosition.getColumn() == column) {
			playerInvalidPosition = true;
			try {
			    Image img2 = ImageIO.read(getClass().getResource("/Pikachu.png"));
			    setIcon(new ImageIcon(img2));
			    setBorderPainted(false);
			  } catch (Exception ex) {
			    System.out.println(ex);
			  }
		}
		
		if (sinkholePosition.getRow() == row && sinkholePosition.getColumn() == column) {
			playerInvalidPosition = true;
			try {
			    Image img3 = ImageIO.read(getClass().getResource("/sinkhole.png"));
			    setIcon(new ImageIcon(img3));
			    setBorderPainted(false);
			  } catch (Exception ex) {
			    System.out.println(ex);
			  }
		}
	}
	

	
	private boolean isTileVisible(Player player) {
		int rowDifference = Math.abs(player.getRow() - row);
		int columnDifference = Math.abs(player.getColumn()- column);
		int totalDifference = rowDifference + columnDifference;
		return totalDifference < 2;
	}
}
