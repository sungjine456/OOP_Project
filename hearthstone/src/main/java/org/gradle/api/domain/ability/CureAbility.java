package org.gradle.api.domain.ability;

import org.gradle.api.domain.card.ServantCard;
import org.gradle.api.domain.hero.Hero;

public class CureAbility implements Ability {
	
	private final int cure;
	
	public CureAbility(int cure){
		this.cure = cure;
	}

	@Override
	public void useAbility(Hero hero) {
		hero.beCure(cure);
	}
	
	@Override
	public void useAbility(ServantCard servantCard) {
		servantCard.beCure(cure);
	}
}
