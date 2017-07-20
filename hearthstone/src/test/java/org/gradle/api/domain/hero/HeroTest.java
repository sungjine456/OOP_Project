package org.gradle.api.domain.hero;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.gradle.api.domain.ability.CureAbility;
import org.junit.Before;
import org.junit.Test;

public class HeroTest {

	private Hero hero;
	
	@Before
	public void setUp(){
		HeroSkill skill = new HeroSkill(new CureAbility(2));
		hero = new Hero(skill);
	}
	
	@Test
	public void noneWeaponTest() {
		assertThat(hero.getOffensePower(), is(0));
	}
}
