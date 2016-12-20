package org.gradle;

import org.gradle.domain.Game;

public class Application {
	public static void main(String[] args){
		Game game = new Game();
		game.start();
	}
}
