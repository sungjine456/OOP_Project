package org.gradle.api.domain.card;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gradle.api.domain.card.Card;
import org.gradle.api.domain.card.CardDeck;
import org.junit.Before;
import org.junit.Test;

public class CardDeckTest {

	private CardDeck cardDeck;
	
	@Before
	public void setUp(){
		cardDeck = new CardDeck();
	}
	
	@Test
	public void firstMakeCardDeckSize() {
		assertThat(cardDeck.getCardDeck().size(), is(30));
	}
	
	@Test
	public void noMoreThanTwoCards(){
		List<Card> cards = cardDeck.getCardDeck();
		Map<Card, Integer> checkMap = new HashMap<>();
		for(Card card : cards){
			if(checkMap.containsKey(card)){
				checkMap.put(card, checkMap.get(card)+1);
			} else {
				checkMap.put(card, 1);
			}
		}
		int max = 0;
		for(Card card : checkMap.keySet()){
			int num = checkMap.get(card);
			if(num > max){
				max = num;
			}
		}
		assertTrue(max < 3);
	}
}
