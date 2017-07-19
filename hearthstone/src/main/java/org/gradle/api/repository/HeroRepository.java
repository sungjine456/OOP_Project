package org.gradle.api.repository;

import java.util.ArrayList;
import java.util.List;

import org.gradle.api.domain.ability.AttackOnlyServantAbility;
import org.gradle.api.domain.ability.AttackServantOrHeroAbility;
import org.gradle.api.domain.ability.CureAbility;
import org.gradle.api.domain.hero.Hero;
import org.gradle.api.domain.hero.HeroSkill;

public class HeroRepository {
	private static final HeroRepository INSTANCE = new HeroRepository();
	public static List<Hero> heroData = new ArrayList<>();
	
	private HeroRepository(){}
	public static HeroRepository getInstance(){
		return INSTANCE;
	}
	
	static {
		heroData.add(new Hero(new HeroSkill(new AttackServantOrHeroAbility(1))));
		heroData.add(new Hero(new HeroSkill(new AttackOnlyServantAbility(1))));
		heroData.add(new Hero(new HeroSkill(new CureAbility(2))));
	}
	
	public Hero getHero(int index){
		return heroData.get(index);
	}
	public int size(){
		return heroData.size();
	}
}
