package org.gradle.api.service;

import java.util.List;

import org.gradle.api.domain.card.Card;
import org.gradle.api.domain.card.ServantCard;
import org.gradle.api.domain.hero.Hero;

public interface GameService {
	void turnOff();
	void putOutTheCard(Card cardToUse, ServantCard targetCard);
	void putOutTheCard(Card cardToUse, Hero targetHero);
	void useTheAbilityOfHero(ServantCard targetCard);
	void useTheAbilityOfHero(Hero targetHero);
	int attackWithHero();
	void attackWithServant();
	List<Card> showCardsThatPlayerHave();
	List<Card> showCardsInTheField();
	Hero showHero();
}
