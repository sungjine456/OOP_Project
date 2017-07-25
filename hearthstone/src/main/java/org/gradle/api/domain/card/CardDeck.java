package org.gradle.api.domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.gradle.api.repository.CardRepository;

public final class CardDeck {
	private final int MAX_CARD_DECK_SIZE = 30;
	
	private List<Card> cardDeck;
	private CardRepository cardRepository;
	
	public CardDeck(){
		cardRepository = CardRepository.getInstance();
		cardDeck = makeFullCardDeck();
	}
	
	public boolean add(Card card){
		if(cardDeck.size() < MAX_CARD_DECK_SIZE){
			return cardDeck.add(card);
		}
		return false;
	}
	public Card getCard(){
		return cardDeck.remove(0);
	}
	public List<Card> getCardDeck(){
		return cardDeck;
	}
	public boolean isEmpty(){
		return cardDeck.isEmpty();
	}
	
	private List<Card> makeFullCardDeck(){
		List<Card> cardList = new ArrayList<>();
		Random random = new Random();
		int numberOfCards = cardRepository.size();
		int[] check = new int[numberOfCards];
		int cardListSize = 0;
		while(cardListSize < MAX_CARD_DECK_SIZE){
			int randomNum = random.nextInt(numberOfCards);
			if(check[randomNum] >= 2){
				continue;
			}
			cardList.add(cardRepository.getCard(randomNum));
			cardListSize += 1;
			check[randomNum] += 1;
		}
		Collections.shuffle(cardList);
		return cardList;
	}
}
