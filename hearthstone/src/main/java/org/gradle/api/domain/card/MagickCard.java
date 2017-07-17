package org.gradle.api.domain.card;

public final class MagickCard implements Card {
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
	@Override
	public String getAbility() {
		return ability;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ability == null) ? 0 : ability.hashCode());
		result = prime * result + mana;
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
		MagickCard other = (MagickCard) obj;
		if (ability == null) {
			if (other.ability != null)
				return false;
		} else if (!ability.equals(other.ability))
			return false;
		if (mana != other.mana)
			return false;
		return true;
	}

	@Override
	public int getOffensePower() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getDefensePower() {
		// TODO Auto-generated method stub
		return 0;
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
