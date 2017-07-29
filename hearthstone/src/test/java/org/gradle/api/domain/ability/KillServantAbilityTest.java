package org.gradle.api.domain.ability;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.gradle.api.domain.card.ServantCard;
import org.gradle.api.domain.hero.Hero;
import org.gradle.api.exception.MethodInvokeException;
import org.junit.Before;
import org.junit.Test;

public class KillServantAbilityTest {

	private KillServantAbility killServantAbility;
	
	@Before
	public void setUp(){
		killServantAbility = new KillServantAbility();
	}

	@Test(expected=MethodInvokeException.class)
	public void killHeroTest() {
		Hero hero = new Hero(new AttackOnlyServantAbility(10));
		
		killServantAbility.useAbility(hero);
	}

	@Test
	public void killServantTest() {
		ServantCard servant = new ServantCard(2, 10, 11);
		
		assertFalse(servant.isDead());
		killServantAbility.useAbility(servant);
		assertTrue(servant.isDead());
	}
}
