package com.javaProject.swing;

import java.awt.*;
import java.beans.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.javaProject.models.GameBoard;
import com.javaProject.models.Player;
import com.javaProject.models.Position;



public class BoardTile extends JButton implements PropertyChangeListener{
	/*
	 * Functionality: Creates a board tile
	 */

	// Fields
	private Position position;
	
	private GameBoard board;

	
	// Constructor
	public BoardTile(GameBoard board, int row, int column){
		super(new MoveAction(board, row, column));
		this.position = new Position(row, column);
		
		this.board = board;

		setPreferredSize(new Dimension(30,30));
		
		board.addPropertyChangeListener(this);
				
//		render(board);
		
		render(board.getPlayerPosition());
	}
	
	
	// Draw corresponding objects to tile
	private void render (Position playerPosition) {
		
		setIcon(null);
		setBackground(null);
		
		if (this.isTileVisible(playerPosition) == false) {
			setBackground(Color.DARK_GRAY);
			setOpaque(true);
			setBorderPainted(false);
		} else {
			
			this.renderPlayer(playerPosition);
			this.renderPikachu(board);
			this.renderSinkhole(board);
		}
	}
	
	private void renderPlayer(Position playerPosition) {
		if (playerPosition.getRow() == this.position.getRow()
				&& playerPosition.getColumn() == this.position.getColumn()) {
			try {
				Image img = ImageIO.read(getClass().getResource("/30x30player.png"));
				setIcon(new ImageIcon(img));
			}catch(Exception ex) {
				System.out.println(ex);
			}
		}
	}
//	private void render (GameBoard gameboard) {
//		
//		setIcon(null);
//		setBackground(null);
//		
//		if (this.isTileVisible(gameboard.getPlayerPosition()) == false) {
//			setBackground(Color.DARK_GRAY);
//			setOpaque(true);
//			setBorderPainted(false);
//		} else {
//			
//			this.renderPlayer(gameboard);
//			this.renderPikachu(gameboard);
//			this.renderSinkhole(gameboard);
//			
//		}
//	}
//	
//	private void renderPlayer(GameBoard board) {
//		if (board.getPlayerPosition().getRow() == this.position.getRow()
//				&& board.getPlayerPosition().getColumn() == this.position.getColumn()) {
//			try {
//				Image img = ImageIO.read(getClass().getResource("/30x30player.png"));
//				setIcon(new ImageIcon(img));
//			}catch(Exception ex) {
//				System.out.println(ex);
//			}
//		}
//	}
	
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
		if(board.hasSinkholeAt(this.position)) {
			try {
			    Image img3 = ImageIO.read(getClass().getResource("/sinkhole.png"));
			    setIcon(new ImageIcon(img3));
			    
			    setBorderPainted(false);
			  } catch (Exception ex) {
			    System.out.println(ex);
			  }
		}
	}
	
	private boolean isTileVisible(Position playerPosition) {
		int rowDifference = Math.abs(playerPosition.getRow() - position.getRow());
		int columnDifference = Math.abs(playerPosition.getColumn()- position.getColumn());
		int totalDifference = rowDifference + columnDifference;
		return totalDifference < 2;
	}
	
	
	// Property change listener
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		switch (evt.getPropertyName()) {
//			case "gameboard":
//				render((GameBoard) evt.getNewValue());
//				break;
			case "playerPosition":
				render((Position) evt.getNewValue());
				break;
		}
	}
}
