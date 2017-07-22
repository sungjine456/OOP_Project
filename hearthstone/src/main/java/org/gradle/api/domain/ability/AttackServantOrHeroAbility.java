package org.gradle.api.domain.ability;

import org.gradle.api.domain.card.ServantCard;
import org.gradle.api.domain.hero.Hero;

public class AttackServantOrHeroAbility extends AbstractAbility {
	
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
