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
		return health <= 0;
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
}
