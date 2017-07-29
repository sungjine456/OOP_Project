package org.gradle.api.domain.ability;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.gradle.api.domain.card.ServantCard;
import org.gradle.api.domain.hero.Hero;
import org.junit.Before;
import org.junit.Test;

public class CureAbilityTest {
	
	private CureAbility cureAbility;
	
	@Before
	public void setUp(){
		cureAbility = new CureAbility(2);
	}

	@Test
	public void cureHeroTest() {
		Hero hero = new Hero(new AttackOnlyServantAbility(10));
		hero.beAttack(10);
		
		assertThat(hero.remainingHealth(), is(20));
		cureAbility.useAbility(hero);
		assertThat(hero.remainingHealth(), is(22));
	}

	@Test
	public void cureServantTest() {
		ServantCard servant = new ServantCard(2, 10, 11);
		servant.beAttack(10);
		
		assertThat(servant.remainingHealth(), is(1));
		cureAbility.useAbility(servant);
		assertThat(servant.remainingHealth(), is(3));
	}
}
