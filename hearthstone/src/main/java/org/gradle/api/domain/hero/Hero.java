package org.gradle.api.domain.hero;

import org.gradle.api.domain.card.WeaponCard;
import org.gradle.api.domain.common.Health;
import org.gradle.api.domain.common.HealthImpl;
import org.gradle.api.domain.common.OffensePower;

public final class Hero implements OffensePower, Health {
	private final HeroSkill skill;
	private WeaponCard weapon;
	
	private Health health;

	public Hero(HeroSkill skill, int health) {
		this.skill = skill;
		weapon = null;
		this.health = new HealthImpl(health);
	}

	public HeroSkill getSkill() {
		return skill;
	}
	@Override
	public int getOffensePower() {
		return weapon==null?0:weapon.getOffensePower();
	}
	public int getDefensePower() {
		return weapon==null?0:weapon.getDefensePower();
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
}
