package org.gradle.api.domain.referee;

import java.util.List;
import java.util.Random;

import org.gradle.api.domain.card.Card;
import org.gradle.api.domain.card.CardDeck;
import org.gradle.api.domain.hero.Hero;
import org.gradle.api.domain.player.Player;
import org.gradle.api.repository.HeroRepository;

public class Referee {
	private final int PLAYER_NUMBER = 2;
	private List<Player> players;
	private List<CardDeck> cardDecks;
	private int turn;

	private HeroRepository heroRepository = HeroRepository.getInstance();
	
	public Referee(){
		for(int i = 0; i < PLAYER_NUMBER; i++){
			players.add(new Player(randomHero()));
			cardDecks.add(new CardDeck());
		}
		firstAttackerDecide();
		begingGiveTheCards(turn, 3);
		int otherPlayer = turn==0?1:0;
		begingGiveTheCards(otherPlayer, 4);
	}

	public void changeTurn(){
		Player player = players.get(turn);
		player.turnOff();
		turn = turn==0?1:0;
	}
	public List<Card> showCardsThatPlayerHave() {
		return players.get(turn).getHandCards();
	}
	public List<Card> showCardsInTheField() {
		return players.get(turn).getFieldCards();
	}
	public Hero showHero() {
		return players.get(turn).getHero();
	}
	
	private void begingGiveTheCards(int turn, int numberOfCards){
		Player player = players.get(turn);
		CardDeck cardDeck = cardDecks.get(turn);
		for(int i = 0; i < numberOfCards; i++){
			player.addCard(cardDeck.getCard());
		}
	}
	private Hero randomHero(){
		Random random = new Random();
		return heroRepository.getHero(random.nextInt(heroRepository.size()));
	}
	private void firstAttackerDecide(){
		Random random = new Random();
		turn = random.nextInt(PLAYER_NUMBER);
	}
}
