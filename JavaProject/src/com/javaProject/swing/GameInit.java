package com.javaProject.swing;

public class GameInit {
	/*
	 *  Functionality: Launch Game
	 */

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Game game = new Game();
			}
		});
	}

}
