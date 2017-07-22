package org.gradle.api.domain.player;

import java.util.ArrayList;
import java.util.List;

import org.gradle.api.domain.ability.Ability;
import org.gradle.api.domain.card.Card;
import org.gradle.api.domain.hero.Hero;
import org.gradle.api.domain.hero.HeroSkill;

public final class Player {
	private final Hero hero;
	private final List<Card> handCards;
	private final List<Card> fieldCards;
	private int mana;
	
	public Player(Hero hero){
		this.hero = hero;
		handCards = new ArrayList<>();
		fieldCards = new ArrayList<>();
		mana = 1;
	}
	
	public void turnOn(Card card){
		handCards.add(card);
		mana += 1;
		hero.getSkill().makeItAvailable();
	}
	public void addCard(Card card){
		handCards.add(card);
	}
	public void removeCardWithHandCards(Card card){
		handCards.remove(card);
	}
	public void putInTheField(Card card){
		if(handCards.contains(card)){
			handCards.remove(card);
			fieldCards.add(card);
		}
	}
	public Ability useCard(Card card){
		return card.useCard(this);
	}
	public HeroSkill useHeroSkcill(){
		return null;
	}
	public int heroAttack(){
		return -1;
	}
	
	public List<Card> getHandCards(){
		return handCards;
	}
	public List<Card> getFieldCards(){
		return fieldCards;
	}
	public Hero getHero(){
		return hero;
	}
	public int getMana(){
		return mana;
	}
}
