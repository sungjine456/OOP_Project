package org.gradle.api.domain.card;

public class MagickCard implements Card {
	private final int mana;
	private final String ability;
	
	public MagickCard(int mana, String ability) {
		this.mana = mana;
		this.ability = ability;
	}

	@Override
	public int getMana() {
		return mana;
	}
	public String getAbility() {
		return ability;
	}
}
