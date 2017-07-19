package org.gradle.api.domain.card;

import org.gradle.api.exception.MethodInvokeException;

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
	public boolean isDead() {
		throw new MethodInvokeException("무기카드는 죽을 수 없습니다.");
	}
	@Override
	public int getHealth() {
		throw new MethodInvokeException("무기카드는 체력을 가질 수 없습니다.");
	}
	@Override
	public void beAttack(int attack) {
		throw new MethodInvokeException("무기카드는 공격받을 수 없습니다.");
	}
	@Override
	public void beCure(int cure) {
		throw new MethodInvokeException("무기카드는 치료받을 수 없습니다.");
	}
}
