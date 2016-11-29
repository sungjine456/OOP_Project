package org.gradle.domain;

import java.util.LinkedList;
import java.util.List;

public class CardDeck {
	private List<Card> cards;
	
	private static final String[] PATTERNS = {"spade", "heart", "diamond", "club"};
	private static final int CARD_COUNT = 13;
	
	public CardDeck(){
		cards = makeCardDeck();
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
		List<Card> cards = new LinkedList<Card>();
		for(String pattern : PATTERNS){
			for(int i = 1; i <= CARD_COUNT; i++){
				cards.add(makeCard(pattern, i));
			}
		}
		return cards;
	}
	
	private Card makeCard(String pattern, int cardNumber){
		String denomination;
		if(cardNumber == 1){
			denomination = "A";
		} else if(cardNumber == 11){
			denomination = "J";
		} else if(cardNumber == 12){
			denomination = "Q";
		} else if(cardNumber == 13){
			denomination = "K";
		} else {
			denomination = String.valueOf(cardNumber);
		}
		
		return new Card(pattern, denomination);
	}
}
