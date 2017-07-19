package org.gradle.api.domain.ability;

import org.gradle.api.domain.card.ServantCard;
import org.gradle.api.domain.hero.Hero;

public class AttackServantOrHeroAbility implements Ability {
	
	private final int attack;
	
	public AttackServantOrHeroAbility(int attack){
		this.attack = attack;
	}

	@Override
	public void useAbility(Hero hero) {
		hero.beAttack(attack);
	}
	
	@Override
	public void useAbility(ServantCard servantCard) {
		servantCard.beAttack(attack);
	}
}
