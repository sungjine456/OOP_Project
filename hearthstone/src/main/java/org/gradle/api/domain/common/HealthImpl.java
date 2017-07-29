package org.gradle.api.domain.common;

public class HealthImpl implements Health {
	private final int health;
	private int attackedAmount;
	
	public HealthImpl(int health){
		this.health = health;
		attackedAmount = 0;
	}
	
	@Override
	public boolean isDead(){
		return remainingHealth() <= 0;
	}
	@Override
	public int remainingHealth(){
		return health - attackedAmount;
	}
	@Override
	public void beAttack(int attack){
		attackedAmount += attack;
	}
	@Override
	public void beCure(int cure){
		attackedAmount -= cure;
		if(attackedAmount < 0){
			attackedAmount = 0;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attackedAmount;
		result = prime * result + health;
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
		HealthImpl other = (HealthImpl) obj;
		if (attackedAmount != other.attackedAmount)
			return false;
		if (health != other.health)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HealthImpl [health=" + health + ", attackedAmount=" + attackedAmount + "]";
	}
}
