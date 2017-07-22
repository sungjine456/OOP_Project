package org.gradle.api.service;

import java.util.List;

import org.gradle.api.domain.card.Card;
import org.gradle.api.domain.common.Health;
import org.gradle.api.domain.hero.Hero;

public interface GameService {
	void turnOff();
	void putOutTheCard(Card cardToUse, Health heroOrServantCard);
	void useTheAbilityOfHero(Health heroOrServantCard);
	int attackWithHero();
	void attackWithServant();
	List<Card> showCardsThatPlayerHave();
	List<Card> showCardsInTheField();
	Hero showHero();
}
