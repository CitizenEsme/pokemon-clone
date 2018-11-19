package com.javaProject.pokemonClone.entities.creatures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.javaProject.pokemonClone.Game;

class PlayerTest {

	Player player;
	
	@BeforeEach
	void setUp() throws Exception {
		Game newGame = new Game("Level 1", 100, 100);
		this.player = new Player(newGame, 0, 0); 
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPlayerCreation() {
		try {
			
		}catch (Exception e) {
			fail("Unable to instantiate player");
		}
	}
	
	@Test
	void testPlayerMovesDown() {
		this.player.moveDown();
		assertEquals(0, this.player.x);
		assertEquals(1, this.player.y);
	}
}
