package org.gradle.api.domain.hero;

import org.gradle.api.domain.ability.Ability;
import org.gradle.api.domain.card.WeaponCard;
import org.gradle.api.domain.common.Health;
import org.gradle.api.domain.common.HealthImpl;
import org.gradle.api.domain.common.Mana;
import org.gradle.api.domain.common.OffensePower;

public final class Hero implements OffensePower, Health, Mana {
	private final int HERO_HEALTH = 30;
	private final int HERO_MANA = 2;
	
	private Health health;
	private WeaponCard weapon;
	private final Ability ability;

	private boolean usedAbility;

	public Hero(Ability ability) {
		this.ability = ability;
		usedAbility = false;
		weapon = null;
		this.health = new HealthImpl(HERO_HEALTH);
	}
	
	public void setWeapon(WeaponCard weapon){
		this.weapon = weapon;
	}
	public boolean hasWeapon(){
		return weapon!=null;
	}
	public void makeWeaponUsable(){
		if(hasWeapon()){
			weapon.makeUsable();
		}
	}
	
	@Override
	public int attack() {
		if(!hasWeapon()){
			return 0;
		}
		
		int offensePower = weapon.attack();

		if(weapon.getDurability() < 1){
			weapon = null;
		}
		
		return offensePower;
	}
	@Override
	public int remainingHealth() {
		return health.remainingHealth();
	}
	@Override
	public boolean isDead() {
		return health.isDead();
	}
	@Override
	public void beAttack(int attack) {
		health.beAttack(attack);
	}
	@Override
	public void beCure(int cure) {
		health.beCure(cure);
	}
	public void useAbility(Health heroOrServantCard){
		disableAbility();
		ability.useAbility(heroOrServantCard);
	}
	public boolean isUsedAbility(){
		return usedAbility;
	}
	public void makeItAvailable(){
		usedAbility = false;
	}
	private void disableAbility(){
		usedAbility = true;
	}
	@Override
	public int getMana() {
		return HERO_MANA;
	}
	public Ability getAbility() {
		return ability;
	}
}
