package org.gradle.api.domain.card;

import static org.junit.Assert.assertTrue;

import org.gradle.api.domain.ability.CureAbility;
import org.junit.Before;
import org.junit.Test;

public class MagicCardTest {
	
	private Card magicCard;
	
	@Before
	public void setUp(){
		magicCard = new MagicCard(1, new CureAbility(1));
	}

	@Test(expected = NullPointerException.class)
	public void constructorTest() {
		new MagicCard(1, null);
	}
	
	@Test
	public void newCardTest(){
		MagicCard magicCard1 = (MagicCard)magicCard.newCard();
		MagicCard magicCard2 = (MagicCard)magicCard.newCard();

		assertTrue((MagicCard)magicCard != magicCard2);
		assertTrue(magicCard1 != magicCard2);
	}
}
