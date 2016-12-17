package org.gradle.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
		Stream.of(PATTERNS).forEach(pattern ->{
			IntStream.rangeClosed(1, CARD_COUNT).forEach(i -> {
				cardDeck.add(new Card(pattern, i));
			});
		});
		return cardDeck;
	}
	
	private Stack<Card> shuffle(List<Card> cardDeck){
		int cardDeckSize = cardDeck.size();
		Stack<Card> shuffleCardDeck = new Stack<Card>();
		IntStream.iterate(cardDeckSize, i -> i - 1).limit(cardDeckSize).forEach(i -> {
			int changeIndex = (int)(Math.random() * i);
			
			shuffleCardDeck.push(cardDeck.get(changeIndex));
			cardDeck.remove(changeIndex);
		});
		return shuffleCardDeck;
	}
}
