package com.javaProject.swing;

import java.awt.*;
import java.beans.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import com.javaProject.models.GameBoard;
import com.javaProject.models.Pikachu;
import com.javaProject.models.Player;
import com.javaProject.models.PlayerPosition;
import com.javaProject.models.Position;
import com.javaProject.models.Sinkhole;


public class BoardTile extends JButton implements PropertyChangeListener{
	/*
	 * Functionality: Creates a board tile
	 */

	// Fields
	private int row;
	private int column;
	private Position position;

	
	// Constructor
	public BoardTile(GameBoard board, int row, int column){
		super(new MoveAction(board, row, column));
		this.row = row;
		this.column = column;
		this.position = new Position(row, column);

		setPreferredSize(new Dimension(30,30));
		
		board.addPropertyChangeListener(this);
				
		render(board);
	}
	
	
	
//	public void addInmobileObjects(ArrayList<Pikachu> pikachuList, ArrayList<Sinkhole> sinkholeList) {
////		for (Pikachu pikachu:pikachuList) {
////			if (pikachu.getRow() == row && pikachu.getColumn() == column) {
////				
////			}
////		}
//		for (Sinkhole sinkhole:sinkholeList) {
//			if (sinkhole.getRow() == row && sinkhole.getColumn() == column) {
//				try {
//				    Image img3 = ImageIO.read(getClass().getResource("/sinkhole.png"));
//				    setIcon(new ImageIcon(img3));
//				    setBorderPainted(false);
//				  } catch (Exception ex) {
//				    System.out.println(ex);
//				  }
//			}
//		}
//	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		switch (evt.getPropertyName()) {
			case "gameboard":
				render((GameBoard) evt.getNewValue());
				break;
		}
	}
	
	private void render (GameBoard gameboard) {
		
		setIcon(null);
		setBackground(null);
		
		if (this.isTileVisible(gameboard.getPlayerPosition()) == false) {
			setBackground(Color.DARK_GRAY);
			setOpaque(true);
			setBorderPainted(false);
		} else {
			
			this.renderPlayer(gameboard);
			this.renderPikachu(gameboard);
			this.renderSinkhole(gameboard);
			
		}
		
//		else if (isTileVisible(gameboard.getPlayerPosition())) {
//			setBackground(null);
//		}else {
//			setBackground(Color.DARK_GRAY);
//			setOpaque(true);
//			setBorderPainted(false);
//		}
	}
	
	private void renderPlayer(GameBoard board) {
		if (board.getPlayerPosition().getRow() == this.position.getRow()
				&& board.getPlayerPosition().getColumn() == this.position.getColumn()) {
//		if (board.getPlayerPosition().equals(this.position)){
			try {
				Image img = ImageIO.read(getClass().getResource("/30x30player.png"));
				setIcon(new ImageIcon(img));
//				setBorderPainted(false);
			}catch(Exception ex) {
				System.out.println(ex);
			}
		}
	}
	
	private void renderPikachu(GameBoard board) {
		if (board.hasPikachuAt(this.position)) {
			try {
				Image img2 = ImageIO.read(getClass().getResource("/Pikachu.png"));
			    setIcon(new ImageIcon(img2));
			    
			    setBorderPainted(false);
			  } catch (Exception ex) {
			    System.out.println(ex);
			}
		}
	}
	
	private void renderSinkhole(GameBoard board) {
		
	}
	
	private boolean isTileVisible(Position playerPosition) {
		int rowDifference = Math.abs(playerPosition.getRow() - row);
		int columnDifference = Math.abs(playerPosition.getColumn()- column);
		int totalDifference = rowDifference + columnDifference;
		return totalDifference < 2;
	}
}
