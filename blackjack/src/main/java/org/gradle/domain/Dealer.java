package org.gradle.domain;

import java.util.ArrayList;
import java.util.List;

public class Dealer implements Player {
	private List<Card> cards;
	private static final int CAN_RECEIVE_POINT = 16;
	
	public Dealer(){
		cards = new ArrayList<Card>();
	}
	
	@Override
	public void receiveCard(Card card){
		if(receivableCard()){
			this.cards.add(card);
			showCards();
		} else {
			System.out.println("카드를 받을 수 없습니다.");
		}
	}
	
	@Override
	public void showCards(){
		StringBuilder sb = new StringBuilder();
		sb.append("보유 중인 카드\n");
		cards.forEach(card -> {
			sb.append(card.toString());
			sb.append("\n");
		});
		System.out.print(sb.toString());
	}
	
	@Override
	public List<Card> openCards(){
		return cards;
	}
	
	private int getPointSum(){
		return cards.stream().mapToInt(card -> card.getPoint()).sum();
	}
	
	private boolean receivableCard(){
		return getPointSum() <= CAN_RECEIVE_POINT;
	}
}
