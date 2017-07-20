package org.gradle.api.service;

import java.util.List;

import org.gradle.api.domain.card.Card;
import org.gradle.api.domain.hero.Hero;
import org.gradle.api.domain.referee.Referee;

public class GameServiceImpl implements GameService {
	
	private Referee referee;
	
	public GameServiceImpl(){
		referee = new Referee();
	}

	@Override
	public void turnOff() {
		referee.changeTurn();
	}

	@Override
	public void putOutTheCard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useThePowerOfHero() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int attackWithHero() {
		return referee.attackWithHero();
	}

	@Override
	public void attackWithServant() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Card> showCardsThatPlayerHave() {
		return referee.showCardsThatPlayerHave();
	}
	@Override
	public List<Card> showCardsInTheField() {
		return referee.showCardsInTheField();
	}
	@Override
	public Hero showHero() {
		return referee.showHero();
	}
}
