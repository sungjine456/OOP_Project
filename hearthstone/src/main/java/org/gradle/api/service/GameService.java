package org.gradle.api.service;

import java.util.List;

import org.gradle.api.domain.card.Card;
import org.gradle.api.domain.hero.Hero;

public interface GameService {
	void turnOff();
	void putOutTheCard();
	void useThePowerOfHero();
	void attackWithHero();
	void attackWithServant();
	List<Card> showCardsThatPlayerHave();
	List<Card> showCardsInTheField();
	Hero showHero();
}
