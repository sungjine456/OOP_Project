package org.gradle.api.domain.referee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.gradle.api.domain.ability.Ability;
import org.gradle.api.domain.card.Card;
import org.gradle.api.domain.card.CardDeck;
import org.gradle.api.domain.card.ServantCard;
import org.gradle.api.domain.hero.Hero;
import org.gradle.api.domain.player.Player;
import org.gradle.api.repository.HeroRepository;

public class Referee {
	private final int PLAYER_MAX_NUMBER = 2;
	private final int FIRST_PLAYER_CARD_NUMBER = 3;
	private final int FIRST_AFTER_PLAYER_CARD_NUMBER = 4;
	private final int FIRST_PLAYER_NUMBER;
	private final int FIRST_AFTER_PLAYER_NUMBER;
	
	private List<Player> players;
	private List<CardDeck> cardDecks;
	private int turn;

	private HeroRepository heroRepository = HeroRepository.getInstance();
	
	public Referee(){
		for(int i = 0; i < PLAYER_MAX_NUMBER; i++){
			players.add(new Player(randomHero()));
			cardDecks.add(new CardDeck());
		}
		List<Integer> number = randomNumbering();
		FIRST_PLAYER_NUMBER = number.get(0);
		FIRST_AFTER_PLAYER_NUMBER = number.get(1);
		begingGiveTheCards(turn, FIRST_PLAYER_CARD_NUMBER);
		begingGiveTheCards(nextTurn(), FIRST_AFTER_PLAYER_CARD_NUMBER);
	}

	public void changeTurn(){
		turn = nextTurn();
		
		Player player = getNowPlayer();
		player.turnOn(getNowCardDeck().getCard());
	}
	public List<Card> showCardsThatPlayerHave() {
		return getNowPlayer().getHandCards();
	}
	public List<Card> showCardsInTheField() {
		return getNowPlayer().getFieldCards();
	}
	public Hero showHero() {
		return getNowPlayer().getHero();
	}
	public int attackWithHero(){
		Hero hero = getNowPlayer().getHero();
		
		return hero.useWeapon();
	}
	public void putOutTheCard(Card cardToUse, ServantCard targetCard) {
		Ability ability = getNowPlayer().useCard(cardToUse);
		if(ability != null){
			ability.useAbility(targetCard);
		}
	}
	public void putOutTheCard(Card cardToUse, Hero targetHero) {
		Ability ability = getNowPlayer().useCard(cardToUse);
		if(ability != null){
			ability.useAbility(targetHero);
		}
	}
	
	private Player getNowPlayer() {
		return players.get(turn);
	}
	private CardDeck getNowCardDeck() {
		return cardDecks.get(turn);
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
	private List<Integer> randomNumbering(){
		List<Integer> number = new ArrayList<>();
		number.add(0);
		number.add(1);
		Collections.shuffle(number);
		return number;
	}
	private int nextTurn(){
		return turn == FIRST_PLAYER_NUMBER ? FIRST_AFTER_PLAYER_NUMBER : FIRST_PLAYER_NUMBER;
	}
}
