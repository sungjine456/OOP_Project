package org.gradle.api.domain.hero;

import org.gradle.api.domain.card.WeaponCard;

public class Hero {
	private final HeroSkill skill;
	private final WeaponCard weapon;
	
	private int health;

	public Hero(HeroSkill skill, int health) {
		this.skill = skill;
		weapon = null;
		this.health = health;
	}

	public HeroSkill getSkill() {
		return skill;
	}
	public int getOffensePower() {
		return weapon==null?0:weapon.getOffensePower();
	}
	public int getDefensePower() {
		return weapon==null?0:weapon.getDefensePower();
	}
	public int getHealth() {
		return health;
	}
}
