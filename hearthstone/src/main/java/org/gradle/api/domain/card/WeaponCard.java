package org.gradle.api.domain.card;

public final class WeaponCard implements Card {
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
	@Override
	public int getOffensePower() {
		return offensePower;
	}
	@Override
	public int getDefensePower() {
		return defensePower;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + defensePower;
		result = prime * result + mana;
		result = prime * result + offensePower;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeaponCard other = (WeaponCard) obj;
		if (defensePower != other.defensePower)
			return false;
		if (mana != other.mana)
			return false;
		if (offensePower != other.offensePower)
			return false;
		return true;
	}

	@Override
	public String getAbility() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void beAttack(int attack) {
		// TODO Auto-generated method stub
	}
	@Override
	public void beCure(int cure) {
		// TODO Auto-generated method stub
	}
}
