package org.gradle.domain;

public class Game {
	public void play(){
		System.out.println("Hello Blackjack Game");
		CardDeck cardDeck = new CardDeck();
		Card card = new Card();
		Gamer gamer = new Gamer();
		Dealer dealer = new Dealer();
		Rule rule = new Rule();
	}
}
