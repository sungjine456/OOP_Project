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
	
	@Test
	public void newCardTest(){
		WeaponCard weaponCard1 = (WeaponCard)weapon.newCard();
		WeaponCard weaponCard2 = (WeaponCard)weapon.newCard();
		weaponCard1.attack();
		assertTrue(weaponCard1.getDurability() != weapon.getDurability());
		assertTrue(weaponCard1.getDurability() != weaponCard2.getDurability());
	}
}
