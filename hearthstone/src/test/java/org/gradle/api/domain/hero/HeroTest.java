package org.gradle.api.domain.hero;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.gradle.api.domain.ability.CureAbility;
import org.gradle.api.domain.card.WeaponCard;
import org.gradle.api.domain.hero.Hero;
import org.gradle.api.domain.hero.HeroSkill;
import org.junit.Before;
import org.junit.Test;

public class HeroTest {

	private final int AMOUNT_MANA = 2;
	
	private Hero hero;
	
	@Before
	public void setUp(){
		HeroSkill skill = new HeroSkill(new CureAbility(AMOUNT_MANA));
		hero = new Hero(skill);
	}
	
	@Test
	public void noneWeaponTest() {
		assertThat(hero.attack(), is(0));
	}
	
	@Test
	public void useWeaponTest(){
		assertThat(hero.attack(), is(0));
		hero.setWeapon(new WeaponCard(0, 1, 1));
		assertThat(hero.attack(), is(1));
		hero.attack();
		assertThat(hero.attack(), is(0));
	}
}
