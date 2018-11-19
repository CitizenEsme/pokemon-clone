package com.javaProject.pokemonClone.entities.creatures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPlayerCreation() {
		try {
			Player player = new Player();
		}catch (Exception e) {
			fail("Unable to instantiate player");
		}
		//fail("Not yet implemented");
	}

}
