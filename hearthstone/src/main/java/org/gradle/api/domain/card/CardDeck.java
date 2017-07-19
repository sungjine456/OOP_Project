package org.gradle.api.domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.gradle.api.repository.CardRepository;

public final class CardDeck {
	private List<Card> cardDeck;
	private final int MAX_CARD_DECK_SIZE = 30;
	private CardRepository cardRepository;
	
	public CardDeck(){
		cardRepository = CardRepository.getInstance();
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
		Random random = new Random();
		int size = cardRepository.size();
		int[] check = new int[size];
		while(cardList.size() < MAX_CARD_DECK_SIZE){
			int randomNum = random.nextInt(size);
			if(check[randomNum] >= 2){
				continue;
			}
			cardList.add(cardRepository.getCard(randomNum));
			check[randomNum] += 1;
		}
		Collections.shuffle(cardList);
		return cardList;
	}
}
