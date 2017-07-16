package org.gradle.domain.hero;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.gradle.api.domain.hero.Hero;
import org.gradle.api.domain.hero.HeroSkill;
import org.junit.Before;
import org.junit.Test;

public class HeroTest {

	private Hero hero;
	
	@Before
	public void setUp(){
		HeroSkill skill = new HeroSkill(2, "영웅을 공격한다.");
		hero = new Hero(skill, 10);
	}
	
	@Test
	public void none_weapon() {
		assertThat(hero.getOffensePower(), is(0));
		assertThat(hero.getDefensePower(), is(0));
	}
}
