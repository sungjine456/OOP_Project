package org.gradle.api.service;

import java.util.List;
import java.util.Map;

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
	public void putOutTheCard(Card cardToUse, Health targetHeroOrServantCard) {
		referee.putOutTheCard(cardToUse, targetHeroOrServantCard);
	}

	@Override
	public void useTheAbilityOfHero(Health targetHeroOrServantCard) {
		referee.useTheAbilityOfHero(targetHeroOrServantCard);
	}

	@Override
	public void attackWithHero(Health targetHeroOrServantCard) {
		referee.attackWithHero(targetHeroOrServantCard);
	}

	@Override
	public void attackWithServant(ServantCard servantCard, Health targetHeroOrServantCard) {
		referee.attackWithServant(servantCard, targetHeroOrServantCard);
	}

	@Override
	public List<Card> showCardsThatPlayerHave() {
		return referee.showCardsThatPlayerHave();
	}
	@Override
	public int getTurn(){
		return referee.getTurn();
	}
	@Override
	public Map<Integer, List<Card>> showCardsInTheField() {
		return referee.showCardsInTheField();
	}
	@Override
	public Hero showHero() {
		return referee.showHero();
	}
}
