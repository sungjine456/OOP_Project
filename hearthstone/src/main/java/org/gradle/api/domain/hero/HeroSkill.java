package org.gradle.api.domain.hero;

import org.gradle.api.domain.ability.Ability;
import org.gradle.api.domain.common.Mana;

public final class HeroSkill implements Mana {
	
	private final int HERO_MANA = 2;
	private final Ability ability;
	
	public HeroSkill(Ability ability) {
		this.ability = ability;
	}

	@Override
	public int getMana() {
		return HERO_MANA;
	}
	public void useAbility(Hero hero){
		ability.useAbility(hero);
	}
}
