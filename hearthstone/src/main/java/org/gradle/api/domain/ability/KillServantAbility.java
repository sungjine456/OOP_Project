package org.gradle.api.domain.ability;

import org.gradle.api.domain.common.Health;
import org.gradle.api.domain.hero.Hero;
import org.gradle.api.exception.MethodInvokeException;

public class KillServantAbility implements Ability {
	
	@Override
	public void useAbility(Health health) {
		if(health instanceof Hero){
			throw new MethodInvokeException("잘못된 대상입니다.");
		}
		health.beAttack(health.remainingHealth());
	}
	
	@Override
	public String toString() {
		return "KillServantAbility []";
	}
}
