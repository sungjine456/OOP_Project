package org.gradle.api.domain.hero;

import org.gradle.api.domain.ability.Ability;
import org.gradle.api.domain.common.Mana;

public final class HeroSkill implements Mana {
	private final int mana;
	private final Ability ability;
	
	public HeroSkill(int mana, Ability ability) {
		this.mana = mana;
		this.ability = ability;
	}

	@Override
	public int getMana() {
		return mana;
	}
}
