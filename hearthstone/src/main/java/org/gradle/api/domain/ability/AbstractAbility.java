package org.gradle.api.domain.ability;

import org.gradle.api.domain.card.ServantCard;
import org.gradle.api.domain.common.Health;
import org.gradle.api.domain.hero.Hero;

public abstract class AbstractAbility implements Ability {

	@Override
	public void useAbility(Health health) {
		if(health instanceof Hero){
			useAbility((Hero)health);
		} else if(health instanceof ServantCard) {
			useAbility((ServantCard)health);
		}
	}
	
	abstract protected void useAbility(Hero hero);
	
	abstract protected void useAbility(ServantCard servantCard);
}
