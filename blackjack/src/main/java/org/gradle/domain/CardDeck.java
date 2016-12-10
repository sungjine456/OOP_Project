package org.gradle.domain;

import java.util.LinkedList;
import java.util.List;

public class CardDeck {
	private List<Card> cards;
	
	private static final String[] PATTERNS = {"spade", "heart", "diamond", "club"};
	private static final int CARD_COUNT = 13;
	
	public CardDeck(){
		this.cards = makeCardDeck();
	}
	
	public Card draw(){
		int select = selector();
		Card card = cards.get(select);
		cards.remove(select);
		
		return card;
	}
	
	private int selector(){
		int size = cards.size();
		return (int)(Math.random() * size);
	}
	
	private List<Card> makeCardDeck(){
		List<Card> cardDeck = new LinkedList<Card>();
		for(String pattern : PATTERNS){
			for(int i = 1; i <= CARD_COUNT; i++){
				cardDeck.add(new Card(pattern, i));
			}
		}
		return cardDeck;
	}
}
