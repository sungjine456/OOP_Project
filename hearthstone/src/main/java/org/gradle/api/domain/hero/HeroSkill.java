package org.gradle.api.domain.hero;

public class HeroSkill {
	private final int mana;
	private final String ability;
	
	public HeroSkill(int mana, String ability) {
		this.mana = mana;
		this.ability = ability;
	}

	public int getMana() {
		return mana;
	}
	public String getAbility() {
		return ability;
	}
}
