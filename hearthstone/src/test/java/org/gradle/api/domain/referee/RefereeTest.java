package org.gradle.api.domain.referee;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.gradle.api.domain.hero.Hero;
import org.junit.Before;
import org.junit.Test;

public class RefereeTest {

	private Referee referee;
	
	@Before
	public void setUp(){
		referee = new Referee();
	}
	
	@Test
	public void nextTurnTest() {
		Hero hero = referee.showHero();
		referee.changeTurn();
		assertNotSame(hero, is(referee.showHero()));
		referee.changeTurn();
		assertSame(hero, is(referee.showHero()));
	}
}
