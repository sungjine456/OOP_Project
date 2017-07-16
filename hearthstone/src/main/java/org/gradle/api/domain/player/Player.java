package org.gradle.api.domain.player;

import org.gradle.api.domain.card.Card;
import org.gradle.api.domain.card.CardDeck;
import org.gradle.api.domain.hero.Hero;
import org.gradle.api.domain.hero.HeroSkill;

public class Player {
	private Hero hero;
	private CardDeck cardDeck;
	private CardDeck handCardDeck;
	private CardDeck fieldCardDeck;
	private int mana;
	
	public Player(Hero hero, CardDeck cardDeck){
		this.hero = hero;
		this.cardDeck = cardDeck;
		handCardDeck = new CardDeck();
		fieldCardDeck = new CardDeck();
		mana = 1;
	}
	
	public void turnOff(){
		
	}
	public Card useCard(){
		return null;
	}
	public HeroSkill useHeroSkcill(){
		return null;
	}
	public int heroAttack(){
		return -1;
	}
}
