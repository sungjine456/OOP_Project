package org.gradle.api.domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CardDeck {
	private List<Card> cardDeck;
	private final int MAX_CARD_DECK_SIZE = 30;
	
	public CardDeck(){
		cardDeck = makeFullCardDeck();
	}
	
	public void remove(Card card){
		cardDeck.remove(card);
	}
	public boolean add(Card card){
		return cardDeck.add(card);
	}
	public List<Card> getCardDeck(){
		return cardDeck;
	}
	public boolean isEmpty(){
		return cardDeck.isEmpty();
	}
	
	private List<Card> makeFullCardDeck(){
		List<Card> cardList = new ArrayList<>();
		Collections.shuffle(cardList);
		return cardList;
	}
}
