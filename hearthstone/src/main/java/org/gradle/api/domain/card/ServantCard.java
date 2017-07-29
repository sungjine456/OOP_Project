package org.gradle.api.domain.card;

import org.gradle.api.domain.ability.Ability;
import org.gradle.api.domain.common.Health;
import org.gradle.api.domain.common.HealthImpl;
import org.gradle.api.domain.common.OffensePower;

public final class ServantCard implements Card, OffensePower, Health {
	private final int mana;
	private int offensePower;
	private final Ability ability;
	private Health health;
	private boolean isAttack;

	public ServantCard(int mana, int offensePower, int health) {
		this.mana = mana;
		this.offensePower = offensePower;
		ability = null;
		this.health = new HealthImpl(health);
		isAttack = false;
	}
	public ServantCard(int mana, int offensePower, Ability ability, int health) {
		this.mana = mana;
		this.offensePower = offensePower;
		this.ability = ability;
		this.health = new HealthImpl(health);
		isAttack = false;
	}

	@Override
	public boolean hasAbility(){
		return ability!=null;
	}
	public void killSerant(){
		health = new HealthImpl(0);
	}
	@Override
	public int attack(){
		if(!isAttack){
			return 0;
		}
		isAttack = false;
		return offensePower;
	}
	@Override
	public Card newCard(){
		return new ServantCard(this.mana, this.offensePower, this.ability, this.health.remainingHealth());
	}
	
	// getter
	public boolean getIsAttack(){
		return isAttack;
	}
	@Override
	public int getMana() {
		return mana;
	}
	@Override
	public int remainingHealth() {
		return health.remainingHealth();
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
	public void useAbility(Health heroOrServantCard) {
		if(hasAbility()){
			ability.useAbility(heroOrServantCard);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ability == null) ? 0 : ability.hashCode());
		result = prime * result + ((health == null) ? 0 : health.hashCode());
		result = prime * result + (isAttack ? 1231 : 1237);
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
		if (health == null) {
			if (other.health != null)
				return false;
		} else if (!health.equals(other.health))
			return false;
		if (isAttack != other.isAttack)
			return false;
		if (mana != other.mana)
			return false;
		if (offensePower != other.offensePower)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ServantCard [mana=" + mana + ", offensePower=" + offensePower + ", ability=" + ability + ", health="
				+ health + ", isAttack=" + isAttack + "]";
	}
}
