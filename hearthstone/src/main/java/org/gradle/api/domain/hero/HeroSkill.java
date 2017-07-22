package org.gradle.api.domain.hero;

import org.gradle.api.domain.ability.Ability;
import org.gradle.api.domain.card.ServantCard;
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
	public void useAbility(Hero hero){
		doNotUse();
		ability.useAbility(hero);
	}
	public void useAbility(ServantCard servantCard){
		doNotUse();
		ability.useAbility(servantCard);
	}
	public boolean getUsedAbility(){
		return usedAbility;
	}
	public void makeItAvailable(){
		usedAbility = false;
	}
	
	private void doNotUse(){
		usedAbility = true;
	}
}
