package org.gradle.api.domain.card;

import org.gradle.api.domain.ability.Ability;
import org.gradle.api.domain.common.OffensePower;
import org.gradle.api.domain.hero.Hero;
import org.gradle.api.domain.player.Player;

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
	public Ability useCard(Player player) {
		Hero hero = player.getHero();
		hero.setWeapon(this);
		player.removeCardWithHandCards(this);
		return null;
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
