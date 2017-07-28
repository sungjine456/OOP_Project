package org.gradle.api.domain.ability;

import org.gradle.api.domain.common.Health;

public class AttackServantOrHeroAbility implements Ability {
	
	private final int attack;
	
	public AttackServantOrHeroAbility(int attack){
		this.attack = attack;
	}

	@Override
	public void useAbility(Health health) {
		health.beAttack(attack);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attack;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttackServantOrHeroAbility other = (AttackServantOrHeroAbility) obj;
		if (attack != other.attack)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AttackServantOrHeroAbility [attack=" + attack + "]";
	}
}
