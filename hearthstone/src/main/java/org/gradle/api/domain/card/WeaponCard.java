package org.gradle.api.domain.card;

public class WeaponCard implements Card {
	private final int mana;
	private final int offensePower;
	private final int defensePower;
	
	public WeaponCard(int mana, int offensePower, int defensePower) {
		this.mana = mana;
		this.offensePower = offensePower;
		this.defensePower = defensePower;
	}
	
	@Override
	public int getMana() {
		return mana;
	}
	public int getOffensePower() {
		return offensePower;
	}
	public int getDefensePower() {
		return defensePower;
	}
}
