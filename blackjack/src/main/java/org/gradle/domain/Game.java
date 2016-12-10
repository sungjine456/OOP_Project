package org.gradle.domain;

import java.util.Scanner;

public class Game {
	private static final int INIT_RECEIVE_CARD_COUNT = 2;
	
	public void play(){
		System.out.println("Hello Blackjack Game");
		Scanner sc = new Scanner(System.in);
		CardDeck cardDeck = new CardDeck();
		Gamer gamer = new Gamer();
		Dealer dealer = new Dealer();
		Rule rule = new Rule();
		
		Card card = cardDeck.draw();
		initPhase(cardDeck, gamer, dealer);
		playingPhase(sc, cardDeck, gamer);
	}
	
	private void playingPhase(Scanner sc, CardDeck cardDeck, Gamer gamer){
		String gamerInput;
		while(true){
			System.out.println("카드를 뽑아주세요.(0을 누르면 종료됩니다.)");
			gamerInput = sc.nextLine();
			if("0".equals(gamerInput)){
				break;
			}
			
			gamer.receiveCard(cardDeck.draw());
		}
	}
	
	private void initPhase(CardDeck cardDeck, Gamer gamer, Dealer dealer){
		System.out.println("처음 2장을 뽑겠습니다.");
		for(int i = 0; i < INIT_RECEIVE_CARD_COUNT; i++){
			gamer.receiveCard(cardDeck.draw());
			dealer.receiveCard(cardDeck.draw());
		}
	}
}
