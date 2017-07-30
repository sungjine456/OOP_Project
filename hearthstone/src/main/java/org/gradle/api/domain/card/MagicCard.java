package org.gradle.api.domain.card;

import org.gradle.api.domain.ability.Ability;
import org.gradle.api.domain.common.Health;

public final class MagicCard implements Card {
	private final int mana;
	private final Ability ability;
	
	public MagicCard(int mana, Ability ability) {
		if(ability == null){
			throw new NullPointerException("능력이 없으면 안됩니다.");
		}
		this.mana = mana;
		this.ability = ability;
	}

	@Override
	public boolean hasAbility(){
		return true;
	}
	@Override
	public int getMana() {
		return mana;
	}
	@Override
	public void useCard(Health heroOrServantCard) {
		ability.useAbility(heroOrServantCard);;
	}
	@Override
	public Card newCard(){
		return new MagicCard(this.mana, this.ability);
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
	public String toString() {
		return "MagicCard [mana=" + mana + ", ability=" + ability + "]";
	}
}
