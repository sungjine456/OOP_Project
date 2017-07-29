package org.gradle.api.domain.hero;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.gradle.api.domain.ability.CureAbility;
import org.gradle.api.domain.card.WeaponCard;
import org.junit.Before;
import org.junit.Test;

public class HeroTest {

	private final int AMOUNT_MANA = 2;
	
	private Hero hero;
	
	@Before
	public void setUp(){
		hero = new Hero(new CureAbility(AMOUNT_MANA));
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
