package org.gradle.api.domain.ability;

import org.gradle.api.domain.card.ServantCard;
import org.gradle.api.domain.hero.Hero;

public interface Ability {
	void useAbility(Hero hero);
	void useAbility(ServantCard servantCard);
}
