package org.gradle.api.domain.referee;

import java.util.List;

import org.gradle.api.domain.card.CardDeck;
import org.gradle.api.domain.hero.Hero;
import org.gradle.api.domain.player.Player;

public class Referee {
	private List<Player> players;
	private List<CardDeck> cardDecks;
	private int turn;
	
	public Referee(){
		players.add(new Player(randomHero()));
		players.add(new Player(randomHero()));
		cardDecks.add(randomCardDeck());
		cardDecks.add(randomCardDeck());
		firstAttackerDecide();
		
	}
	
	public void gameReady(){
		
	}
	
	private Hero randomHero(){
		return null;
	}
	private CardDeck randomCardDeck(){
		return null;
	}
	private void firstAttackerDecide(){
		turn = 0;
	}
}
