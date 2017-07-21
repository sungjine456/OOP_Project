package org.gradle.api.domain.card;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class WeaponCardTest {
	
	private final int AMOUNT_HEALTH = 2;
	private final int OFFENSE_POWER = 5;
	private final int AMOUNT_DURABILITY = 2;

	private WeaponCard weapon;
	
	@Before
	public void setUp(){
		weapon = new WeaponCard(AMOUNT_HEALTH, OFFENSE_POWER, AMOUNT_DURABILITY);
	}
	
	@Test
	public void decrementDurabilityTest() {
		assertThat(weapon.getDurability(), is(2));
		weapon.attack();
		assertThat(weapon.getDurability(), is(1));
		weapon.attack();
		assertThat(weapon.getDurability(), is(0));
	}
}
