package org.gradle.api.domain.referee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.gradle.api.domain.card.Card;
import org.gradle.api.domain.card.CardDeck;
import org.gradle.api.domain.card.ServantCard;
import org.gradle.api.domain.common.Health;
import org.gradle.api.domain.hero.Hero;
import org.gradle.api.domain.player.Player;
import org.gradle.api.exception.MethodInvokeException;
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
		players = new ArrayList<>();
		cardDecks = new ArrayList<>();
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
	public int getTurn(){
		return turn;
	}
	public List<Card> showCardsThatPlayerHave() {
		return getNowPlayer().getHandCards();
	}
	public Map<Integer, List<Card>> showCardsInTheField() {
		Map<Integer, List<Card>> cardsInFieldMap = new HashMap<>();
		for(int i = 0; i < PLAYER_MAX_NUMBER; i++){
			cardsInFieldMap.put(i, getNowPlayer().getFieldCards());
		}
		return cardsInFieldMap;
	}
	public Hero showHero() {
		return getNowPlayer().getHero();
	}
	public void attackWithHero(Health targetHeroOrServantCard){
		Hero nowHero = getNowPlayer().getHero();
		targetHeroOrServantCard.beAttack(nowHero.attack());
	}
	public void attackWithServant(ServantCard servantCard, Health targetHeroOrServantCard) {
		if(getNowPlayer().noCardToAttackInField(servantCard)){
			throw new MethodInvokeException("필드에 없는 카드입니다.");
		}
		if(!servantCard.getIsAttack()){
			throw new MethodInvokeException("이미 공격한 카드입니다.");
		}
		targetHeroOrServantCard.beAttack(servantCard.attack());
	}
	public void putOutTheCard(Card cardToUse) {
		if(cardToUse.hasAbility()){
			getNowPlayer().useCard(cardToUse);
		}
	}
	public void putOutTheCard(Card cardToUse, Health targetHeroOrServantCard) {
		if(cardToUse.hasAbility()){
			getNowPlayer().useCard(cardToUse, targetHeroOrServantCard);
		}
	}
	public void useTheAbilityOfHero(Health targetHeroOrServantCard) {
		Hero hero = getNowPlayer().getHero();
		if(!hero.isUsedAbility()){
			hero.useAbility(targetHeroOrServantCard);
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
