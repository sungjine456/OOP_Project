package org.gradle.api.service;

import java.util.List;

import org.gradle.api.domain.card.Card;
import org.gradle.api.domain.card.ServantCard;
import org.gradle.api.domain.common.Health;
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
	public void putOutTheCard(Card cardToUse) {
		referee.putOutTheCard(cardToUse);
	}
	@Override
	public void putOutTheCard(Card cardToUse, Health heroOrServantCard) {
		referee.putOutTheCard(cardToUse, heroOrServantCard);
	}

	@Override
	public void useTheAbilityOfHero(Health heroOrServantCard) {
		referee.useTheAbilityOfHero(heroOrServantCard);
	}

	@Override
	public void attackWithHero(Health heroOrServantCard) {
		referee.attackWithHero(heroOrServantCard);
	}

	@Override
	public void attackWithServant(ServantCard servantCard, Health heroOrServantCard) {
		referee.attackWithServant(servantCard, heroOrServantCard);
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
