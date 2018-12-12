package com.javaProject.swing;

import java.awt.*;
import java.beans.*;
import java.util.ArrayList;

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
	private boolean iconIsVisible = false;


	
	// Constructor
	public BoardTile(GameBoard board, int row, int column){
		super(new MoveAction(board, row, column));
		this.row = row;
		this.column = column;

		setPreferredSize(new Dimension(30,30));
		
		board.addPropertyChangeListener(this);	
		
		this.renderWithPlayer(board.getPlayer());
		this.renderWithNoneMovingObjects(board.getPikachuList(), board.getSinkholeList());
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		switch (evt.getPropertyName()) {
			case "player":
				renderWithPlayer((Player) evt.getNewValue());
				break;
		}
	}
	
	private void renderWithPlayer (Player position) {
		if (position.getRow() == row && position.getColumn() == column) {
			try {
				Image img = ImageIO.read(getClass().getResource("/30x30player.png"));
				setIcon(new ImageIcon(img));
//				setBorderPainted(false);
			}catch(Exception ex) {
				System.out.println(ex);
			}
		} else if(position.getPriorRow() == row && position.getPriorColumn() == column) {
			setIcon(null);
		}else if (isTileVisible(position)) {
			iconIsVisible = true;
		}else {
			iconIsVisible = false;
		}
	}

	
	private void renderWithNoneMovingObjects(ArrayList<Pikachu> pikachuList, ArrayList<Sinkhole> sinkholeList) {
		for (Pikachu pikachu:pikachuList) {
			if (pikachu.getRow() == row && pikachu.getColumn() == column) {
				if (iconIsVisible == true) {
					try {
					    Image img2 = ImageIO.read(getClass().getResource("/Pikachu.png"));
					    setIcon(new ImageIcon(img2));
					    setBorderPainted(false);
					  } catch (Exception ex) {
					    System.out.println(ex);
					}
				}
			}
		}
		for (Sinkhole sinkhole:sinkholeList) {
			if (sinkhole.getRow() == row && sinkhole.getColumn() == column) {
				if (iconIsVisible == true) {
					try {
					    Image img3 = ImageIO.read(getClass().getResource("/sinkhole.png"));
					    setIcon(new ImageIcon(img3));
					    setBorderPainted(false);
					  } catch (Exception ex) {
					    System.out.println(ex);
					  }
				}
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
