package org.gradle;

import org.gradle.service.Game;

public class Application {
	public static void main(String[] args){
		Game game = new Game();
		game.start();
	}
}
