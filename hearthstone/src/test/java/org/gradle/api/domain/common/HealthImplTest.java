package org.gradle.api.domain.common;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import org.gradle.api.domain.common.Health;
import org.gradle.api.domain.common.HealthImpl;
import org.junit.Before;
import org.junit.Test;

public class HealthImplTest {
	
	private final int MAX_HEALTH = 10;

	private Health health;
	
	@Before
	public void setup(){
		health = new HealthImpl(MAX_HEALTH);
	}
	
	@Test
	public void getHealthAndBeAttackTest(){
		assertThat(health.remainingHealth(), is(10));
		health.beAttack(2);
		assertThat(health.remainingHealth(), is(8));
		health.beAttack(4);
		assertThat(health.remainingHealth(), is(4));
		health.beAttack(5);
		assertThat(health.remainingHealth(), is(-1));
	}
	
	@Test
	public void beCureTest(){
		health.beAttack(10);
		assertThat(health.remainingHealth(), is(0));
		health.beCure(2);
		assertThat(health.remainingHealth(), is(2));
		health.beCure(4);
		assertThat(health.remainingHealth(), is(6));
		health.beCure(4);
		assertThat(health.remainingHealth(), is(10));
		health.beCure(6);
		assertThat(health.remainingHealth(), is(10));
	}
	
	@Test
	public void idDeadTest() {
		assertFalse(health.isDead());
		health.beAttack(10);
		assertFalse(health.isDead());
	}
}
