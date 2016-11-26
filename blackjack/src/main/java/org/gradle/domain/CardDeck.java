package org.gradle.domain;

import java.util.LinkedList;
import java.util.List;

public class CardDeck {
	private List<Card> cards;
	
	private static final String[] PATTERNS = {"spade", "heart", "diamond", "club"};
	private static final int CARD_COUNT = 13;
	
	public CardDeck(){
		cards = new LinkedList<Card>();
		for(String pattern : PATTERNS){
			for(int i = 1; i <= CARD_COUNT; i++){
				String denomination;
				if(i == 1){
					denomination = "A";
				} else if(i == 11){
					denomination = "J";
				} else if(i == 12){
					denomination = "Q";
				} else if(i == 13){
					denomination = "K";
				} else {
					denomination = String.valueOf(i);
				}
				cards.add(new Card(pattern, denomination));
			}
		}
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
}
