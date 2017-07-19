package org.gradle.api.domain.ability;

import org.gradle.api.domain.card.ServantCard;
import org.gradle.api.domain.hero.Hero;
import org.gradle.api.exception.MethodInvokeException;

public class AttackOnlyServantAbility implements Ability {
	
	private final int attack;
	
	public AttackOnlyServantAbility(int attack){
		this.attack = attack;
	}

	@Override
	public void useAbility(Hero hero) {
		throw new MethodInvokeException("잘못된 대상입니다.");
	}
	
	@Override
	public void useAbility(ServantCard servantCard) {
		servantCard.beAttack(attack);
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
		AttackOnlyServantAbility other = (AttackOnlyServantAbility) obj;
		if (attack != other.attack)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AttackOnlyServantAbility [attack=" + attack + "]";
	}
}
