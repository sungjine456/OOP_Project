package org.gradle.api.domain.player;

import java.util.ArrayList;
import java.util.List;

import org.gradle.api.domain.card.Card;
import org.gradle.api.domain.hero.Hero;
import org.gradle.api.domain.hero.HeroSkill;

public final class Player {
	private Hero hero;
	private List<Card> handCardDeck;
	private List<Card> fieldCardDeck;
	private int mana;
	
	public Player(Hero hero){
		this.hero = hero;
		handCardDeck = new ArrayList<>();
		fieldCardDeck = new ArrayList<>();
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
