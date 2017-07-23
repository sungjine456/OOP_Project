package org.gradle.api.domain.card;

import org.gradle.api.domain.common.Health;
import org.gradle.api.domain.common.OffensePower;
import org.gradle.api.exception.MethodInvokeException;

public final class WeaponCard implements Card, OffensePower {
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
	public boolean hasAbility(){
		return false;
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
	public void makeUsable() {
		isAttack = true;
	}
	@Override
	public void useAbility(Health heroOrServantCard) {
		throw new MethodInvokeException("무기카드는 능력이 없습니다.");
	}
	@Override
	public Card newCard(){
		return new WeaponCard(this.mana, this.offensePower, this.durability);
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
}
