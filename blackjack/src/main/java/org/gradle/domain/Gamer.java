package org.gradle.domain;

import java.util.ArrayList;
import java.util.List;

public class Gamer implements Player {
	private List<Card> cards;
	
	public Gamer(){
		cards = new ArrayList<Card>();
	}
	
	@Override
	public void receiveCard(Card card){
		this.cards.add(card);
		showCards();
	}
	
	@Override
	public void showCards(){
		StringBuilder sb = new StringBuilder();
		sb.append("보유 중인 카드\n");
		for(Card card : cards){
			sb.append(card.toString());
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	
	@Override
	public List<Card> openCards(){
		return this.cards;
	}
}
