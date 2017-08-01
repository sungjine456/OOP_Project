package org.gradle.api.domain.player;

import java.util.ArrayList;
import java.util.List;

import org.gradle.api.domain.ability.Ability;
import org.gradle.api.domain.card.Card;
import org.gradle.api.domain.card.ServantCard;
import org.gradle.api.domain.card.WeaponCard;
import org.gradle.api.domain.common.Health;
import org.gradle.api.domain.hero.Hero;
import org.gradle.api.exception.MethodInvokeException;

public final class Player {
	private final Hero hero;
	private final List<Card> handCards;
	private final List<Card> fieldCards;
	private int mana;
	private int useMana;
	
	public Player(Hero hero){
		this.hero = hero;
		handCards = new ArrayList<>();
		fieldCards = new ArrayList<>();
		mana = 1;
		useMana = 0;
	}
	
	public void turnOn(Card card){
		handCards.add(card);
		mana += 1;
		hero.makeItAvailable();
		useMana = 0;
		if(hero.hasWeapon()){
			hero.makeWeaponUsable();
		}
	}
	public void addCard(Card card){
		handCards.add(card);
	}
	public void removeCardWithHandCards(Card card){
		handCards.remove(card);
	}
	public void useCard(Card card){
		if(card.hasAbility()){
			throw new MethodInvokeException("능력을 사용할 대상을 지정해주세요.");
		}
		if(handCards.contains(card)){
			if(card instanceof WeaponCard){
				hero.setWeapon((WeaponCard)card);
			}
			if(card instanceof ServantCard){
				fieldCards.add((ServantCard)card);
			}

			useMana(card.getMana());
			
			handCards.remove(card);
		}
	}
	public void useCard(Card card, Health heroOrServantCard){
		if(heroOrServantCard instanceof ServantCard){
			if(noCardToAttackInField((ServantCard)heroOrServantCard)){
				throw new MethodInvokeException("공격할 대상이 없습니다.");
			}
		}
		if(handCards.contains(card)){
			if(card.hasAbility()){
				card.useCard(heroOrServantCard);
			}
			
			useMana(card.getMana());
			
			handCards.remove(card);
		}
	}
	public boolean noCardToAttackInField(ServantCard targetCard){
		return fieldCards.stream().filter(card -> targetCard.equals(card)).findAny() == null;
	}
	public Ability useHeroSkill(){
		useMana(hero.getMana());
		
		return hero.getAbility();
	}
	public int heroAttack(){
		return hero.attack();
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
	public int remainingMana(){
		return mana - useMana;
	}
	
	private void useMana(int mana){
		if(this.mana < useMana + mana){
			throw new MethodInvokeException("마나가 모자릅니다.");
		}
		useMana += mana;
	}
}
