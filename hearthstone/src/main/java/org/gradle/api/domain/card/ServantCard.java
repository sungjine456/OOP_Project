package org.gradle.api.domain.card;

public class ServantCard implements Card {
	private final int mana;
	private final int offensePower;
	private final String ability;
	
	private int health;

	public ServantCard(int mana, int offensePower, String ability, int health) {
		this.mana = mana;
		this.offensePower = offensePower;
		this.ability = ability;
		this.health = health;
	}

	public boolean hasAbility(){
		return false;
	}
	
	// getter
	@Override
	public int getMana() {
		return mana;
	}
	public int getOffensePower() {
		return offensePower;
	}
	public String getAbility() {
		return ability;
	}
	public int getHealth() {
		return health;
	}
}
