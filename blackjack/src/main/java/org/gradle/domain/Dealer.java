package org.gradle.domain;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
	private List<Card> cards;
	private static final int CAN_RECEIVE_POINT = 16;
	
	public Dealer(){
		cards = new ArrayList<Card>();
	}
	
	public void receiveCard(Card card){
		if(this.getPointSum() <= CAN_RECEIVE_POINT){
			this.cards.add(card);
		} else {
			System.out.println("카드를 받을 수 없습니다.");
		}
	}
	
	private int getPointSum(){
		int sum = 0;
		for(Card card : this.cards){
			sum += card.getPoint();
		}
		
		return sum;
	}
	
	public List<Card> openCards(){
		return null;
	}
}
