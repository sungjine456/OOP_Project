package org.gradle.api.domain.card;

import org.gradle.api.domain.ability.Ability;
import org.gradle.api.exception.MethodInvokeException;

public final class MagicCard implements Card {
	private final int mana;
	private final Ability ability;
	
	public MagicCard(int mana, Ability ability) {
		this.mana = mana;
		this.ability = ability;
	}

	@Override
	public int getMana() {
		return mana;
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
		MagicCard other = (MagicCard) obj;
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
		throw new MethodInvokeException("마법 카드는 공격력이 없습니다.");
	}
	@Override
	public boolean isDead() {
		throw new MethodInvokeException("마법 카드는 죽을 수 없습니다.");
	}
	@Override
	public int getHealth() {
		throw new MethodInvokeException("마법 카드는 생명력이 없습니다.");
	}
	@Override
	public void beAttack(int attack) {
		throw new MethodInvokeException("마법 카드는 공격받을 수 없습니다.");
	}
	@Override
	public void beCure(int cure) {
		throw new MethodInvokeException("마법 카드는 치료받을 수 없습니다.");
	}
}
