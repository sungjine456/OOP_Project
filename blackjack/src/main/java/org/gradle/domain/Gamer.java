package org.gradle.domain;

import java.util.ArrayList;
import java.util.List;

public class Gamer {
	private List<Card> cards;
	
	public Gamer(){
		cards = new ArrayList<Card>();
	}
	
	public void receiveCard(Card card){
		this.cards.add(card);
		showCard();
	}
	
	public void showCard(){
		StringBuilder sb = new StringBuilder();
		sb.append("보유 중인 카드");
		sb.append("\n");
		for(Card card : cards){
			sb.append(card.toString());
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public List<Card> openCards(){
		return this.cards;
	}
}
