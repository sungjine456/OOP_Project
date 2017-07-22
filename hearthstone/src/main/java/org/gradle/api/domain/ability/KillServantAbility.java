package org.gradle.api.domain.ability;

import org.gradle.api.domain.card.ServantCard;
import org.gradle.api.domain.hero.Hero;
import org.gradle.api.exception.MethodInvokeException;

public class KillServantAbility extends AbstractAbility {
	
	@Override
	public void useAbility(Hero hero) {
		throw new MethodInvokeException("잘못된 대상입니다.");
	}
	
	@Override
	public void useAbility(ServantCard servantCard) {
		servantCard.beAttack(servantCard.remainingHealth());
	}

	@Override
	public String toString() {
		return "KillServantAbility []";
	}
}
