package com.javaProject.swing;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.javaProject.models.GameBoard;

public class MoveAction extends AbstractAction{
	/*
	 * Functionality: Tile buttons react to clicks
	 */
	
	// Fields
	private int row;
	private int column;
	private GameBoard board;
	
	// Constructor
	public MoveAction(GameBoard board, int row, int column) {
		this.row = row;
		this.column = column;
		this.board = board;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		board.movePlayer(row, column);
		board.move(board.getPlayer()).to(row, column);
	}

}
