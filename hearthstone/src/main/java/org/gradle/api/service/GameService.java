package org.gradle.api.service;

import java.util.List;

import org.gradle.api.domain.card.Card;
import org.gradle.api.domain.card.ServantCard;
import org.gradle.api.domain.common.Health;
import org.gradle.api.domain.hero.Hero;

public interface GameService {
	void turnOff();
	void putOutTheCard(Card cardToUse);
	void putOutTheCard(Card cardToUse, Health heroOrServantCard);
	void useTheAbilityOfHero(Health heroOrServantCard);
	void attackWithHero(Health heroOrServantCard);
	void attackWithServant(ServantCard servantCard, Health heroOrServantCard);
	List<Card> showCardsThatPlayerHave();
	List<Card> showCardsInTheField();
	Hero showHero();
}
