package org.gradle.api.domain.card;

import org.gradle.api.domain.ability.Ability;
import org.gradle.api.domain.common.Health;
import org.gradle.api.domain.common.HealthImpl;

public final class ServantCard implements Card {
	private final int mana;
	private int offensePower;
	private final Ability ability;
	private Health health;

	public ServantCard(int mana, int offensePower, int health) {
		this.mana = mana;
		this.offensePower = offensePower;
		ability = null;
		this.health = new HealthImpl(health);
	}
	public ServantCard(int mana, int offensePower, Ability ability, int health) {
		this.mana = mana;
		this.offensePower = offensePower;
		this.ability = ability;
		this.health = new HealthImpl(health);
	}

	public boolean hasAbility(){
		return ability!=null;
	}
	public void killSerant(){
		health = new HealthImpl(0);
	}
	
	// getter
	@Override
	public int getMana() {
		return mana;
	}
	@Override
	public int getOffensePower() {
		return offensePower;
	}
	@Override
	public int getHealth() {
		return health.getHealth();
	}
	@Override
	public boolean isDead() {
		return health.isDead();
	}
	@Override
	public void beAttack(int attack) {
		health.beAttack(attack);
	}
	@Override
	public void beCure(int cure) {
		health.beCure(cure);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ability == null) ? 0 : ability.hashCode());
		result = prime * result + mana;
		result = prime * result + offensePower;
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
		ServantCard other = (ServantCard) obj;
		if (ability == null) {
			if (other.ability != null)
				return false;
		} else if (!ability.equals(other.ability))
			return false;
		if (mana != other.mana)
			return false;
		if (offensePower != other.offensePower)
			return false;
		return true;
	}
}
