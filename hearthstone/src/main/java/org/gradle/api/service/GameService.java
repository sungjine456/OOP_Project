package org.gradle.api.service;

import java.util.List;
import java.util.Map;

import org.gradle.api.domain.card.Card;
import org.gradle.api.domain.card.ServantCard;
import org.gradle.api.domain.common.Health;
import org.gradle.api.domain.hero.Hero;

public interface GameService {
	void turnOff();
	void putOutTheCard(Card cardToUse);
	void putOutTheCard(Card cardToUse, Health targetHeroOrServantCard);
	void useTheAbilityOfHero(Health targetHeroOrServantCard);
	void attackWithHero(Health targetHeroOrServantCard);
	void attackWithServant(ServantCard servantCard, Health targetHeroOrServantCard);
	List<Card> showCardsThatPlayerHave();
	int getTurn();
	Map<Integer, List<Card>> showCardsInTheField();
	Hero showHero();
}
