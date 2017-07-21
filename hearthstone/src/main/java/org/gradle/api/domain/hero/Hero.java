package org.gradle.api.domain.hero;

import org.gradle.api.domain.card.WeaponCard;
import org.gradle.api.domain.common.Health;
import org.gradle.api.domain.common.HealthImpl;
import org.gradle.api.domain.common.OffensePower;

public final class Hero implements OffensePower, Health {
	private final int HERO_HEALTH = 30;
	
	private final HeroSkill skill;
	private WeaponCard weapon;
	
	private Health health;

	public Hero(HeroSkill skill) {
		this.skill = skill;
		weapon = null;
		this.health = new HealthImpl(HERO_HEALTH);
	}
	
	public void setWeapon(WeaponCard weapon){
		this.weapon = weapon;
	}
	public HeroSkill getSkill() {
		return skill;
	}
	public int useWeapon(){
		if(!hasWeapon()){
			return 0;
		}
		
		int offensePower = weapon.attack();

		if(weapon.getDurability() < 1){
			weapon = null;
		}
		
		return offensePower;
	}
	
	@Override
	public int attack() {
		return weapon==null?0:weapon.attack();
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
	
	private boolean hasWeapon(){
		return weapon!=null;
	}
}
