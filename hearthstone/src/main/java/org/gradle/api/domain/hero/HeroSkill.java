package org.gradle.api.domain.hero;

import org.gradle.api.domain.common.Ability;
import org.gradle.api.domain.common.Mana;

public final class HeroSkill implements Mana, Ability {
	private final int mana;
	private final String ability;
	
	public HeroSkill(int mana, String ability) {
		this.mana = mana;
		this.ability = ability;
	}

	@Override
	public int getMana() {
		return mana;
	}
	@Override
	public String getAbility() {
		return ability;
	}
}
