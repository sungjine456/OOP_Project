package org.gradle.api.domain.card;

import org.gradle.api.exception.MethodInvokeException;

public final class WeaponCard implements Card {
	private final int mana;
	private final int offensePower;
	
	private int durability;
	private boolean isAttack;
	
	public WeaponCard(int mana, int offensePower, int durability) {
		this.mana = mana;
		this.offensePower = offensePower;
		this.durability = durability;
		isAttack = true;
	}
	
	@Override
	public int getMana() {
		return mana;
	}
	@Override
	public int attack(){
		if(!isAttack){
			return 0;
		}
		isAttack = false;
		durability -= 1;
		return offensePower;
	}
	public boolean getIsAttack(){
		return isAttack;
	}
	public int getDurability() {
		return durability;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + durability;
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
		if (durability != other.durability)
			return false;
		if (mana != other.mana)
			return false;
		if (offensePower != other.offensePower)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "WeaponCard [mana=" + mana + ", offensePower=" + offensePower + ", durability=" + durability + "]";
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
