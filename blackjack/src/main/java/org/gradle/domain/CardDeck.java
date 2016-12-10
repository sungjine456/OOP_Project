package org.gradle.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CardDeck {
	private Stack<Card> cards;
	
	private static final String[] PATTERNS = {"spade", "heart", "diamond", "club"};
	private static final int CARD_COUNT = 13;
	
	public CardDeck(){
		this.cards = shuffle(makeCardDeck());
	}
	
	public Card draw(){
		return cards.pop();
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
	
	private Stack<Card> shuffle(List<Card> cardDeck){
		int cardDeckSize = cardDeck.size();
		Stack<Card> shuffleCardDeck = new Stack<Card>();
		while(cardDeckSize > 0){
			int changeIndex = (int)(Math.random() * cardDeckSize);
			
			shuffleCardDeck.push(cardDeck.get(changeIndex));
			cardDeck.remove(changeIndex);
			
			cardDeckSize--;
		}
		return shuffleCardDeck;
	}
}
