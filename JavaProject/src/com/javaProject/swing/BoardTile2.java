//package com.javaProject.swing;
//
//import java.awt.*;
//import java.beans.*;
//import java.util.ArrayList;
//
//import javax.imageio.ImageIO;
//import javax.swing.*;
//import com.javaProject.models.GameBoard;
//import com.javaProject.models.Pikachu;
//import com.javaProject.models.Player;
//import com.javaProject.models.Sinkhole;
//
//
//public class BoardTile extends JButton implements PropertyChangeListener{
//	/*
//	 * Functionality: Creates a board tile
//	 */
//	// Fields
//	private int row;
//	private int column;
//	private JLabel iconLabel;
//	
//	private boolean playerMoved = false;
//	private boolean redraw = false;
//
//
//	
//	// Constructor
//	public BoardTile(GameBoard board, int row, int column){
//		super(new MoveAction(board, row, column));
//		this.row = row;
//		this.column = column;
//
//		setPreferredSize(new Dimension(30,30));
//		
//		board.addPropertyChangeListener(this);
//		
//		
//		drawAllObjects(board.getPlayer(), board.getPikachuList(), board.getSinkholeList());
//		moveDetected();
////		redrawPlayer();
////		redrawPikachuSinkhole();
//	}
//	
//	private void drawAllObjects(Player player, ArrayList<Pikachu> pikachuList, ArrayList<Sinkhole> sinkholeList) {
//		if (player.getRow() == row && player.getColumn() == column) {
//			try {
//				Image img = ImageIO.read(getClass().getResource("/30x30player.png"));
//				setIcon(new ImageIcon(img));
//			}catch(Exception ex) {
//				System.out.println(ex);
//			}
//
//		}else if (isTileVisible(player)) {
//
//		}else {
//			setBackground(Color.DARK_GRAY);
//			setOpaque(true);
//			setBorderPainted(true);
//		}
//		
//		for (Pikachu pikachu:pikachuList) {
//			if (pikachu.getRow() == row && pikachu.getColumn() == column) {
//				try {
//					Image img2 = ImageIO.read(getClass().getResource("/Pikachu.png"));
//				    setIcon(new ImageIcon(img2));
//					
//				    JLabel iconLabel = new JLabel(new ImageIcon(BoardTile.class.getResource("/WHITEBOX.png")));
//				    add(iconLabel);
//				    
//				    setBorderPainted(false);
//				  } catch (Exception ex) {
//				    System.out.println(ex);
//				}
//			}
//		}
//		
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
//	
//	private boolean isTileVisible(Player player) {
//		int rowDifference = Math.abs(player.getRow() - row);
//		int columnDifference = Math.abs(player.getColumn()- column);
//		int totalDifference = rowDifference + columnDifference;
//		return totalDifference < 2;
//	}
//	
//	private void moveDetected() {
//		if (playerMoved) {
//			setIcon(null);
//			playerMoved = false;
//		}
//	}
//
//
//
//	@Override
//	public void propertyChange(PropertyChangeEvent evt) {
//		switch (evt.getPropertyName()) {
//			case "player":
////				redrawPlayer((Player) evt.getNewValue());
//				playerMoved = true;
//				moveDetected();
//				break;
//		}
//	}
//}