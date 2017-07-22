package org.gradle.api.domain.hero;

import org.gradle.api.domain.ability.Ability;
import org.gradle.api.domain.common.Health;
import org.gradle.api.domain.common.Mana;

public final class HeroSkill implements Mana {
	
	private final int HERO_MANA = 2;
	
	private final Ability ability;
	private boolean usedAbility;
	
	public HeroSkill(Ability ability) {
		this.ability = ability;
		usedAbility = false;
	}

	@Override
	public int getMana() {
		return HERO_MANA;
	}
	public void useAbility(Health heroOrServantCard){
		disableAbility();
		ability.useAbility(heroOrServantCard);
	}
	public boolean getUsedAbility(){
		return usedAbility;
	}
	public void makeItAvailable(){
		usedAbility = false;
	}
	
	private void disableAbility(){
		usedAbility = true;
	}
}
