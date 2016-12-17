package org.gradle.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;

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
		List<Player> players = Arrays.asList(gamer, dealer);
		
		initPhase(cardDeck, players);
		playingPhase(sc, cardDeck, gamer, dealer);
	}
	
	private void playingPhase(Scanner sc, CardDeck cardDeck, Gamer gamer, Dealer dealer){
		String gamerInput;
		String dealerInput;
		boolean isGamerTurnOff = false;
		boolean isDealerTurnOff = false;
		while(true){
			System.out.println("카드를 뽑아주세요.(0을 누르면 종료됩니다.)");
			gamerInput = sc.nextLine();
			if("0".equals(gamerInput)){
				isGamerTurnOff = true;
			} else {
				gamer.receiveCard(cardDeck.draw());
			}
			
			System.out.println("카드를 뽑아주세요.(0을 누르면 종료됩니다.)");
			dealerInput = sc.nextLine();
			if("0".equals(dealerInput)){
				isDealerTurnOff = true;
			} else {
				dealer.receiveCard(cardDeck.draw());
			}
			
			if(isGamerTurnOff && isDealerTurnOff){
				break;
			}
		}
	}
	
	private void initPhase(CardDeck cardDeck, List<Player> players){
		System.out.println("처음 2장을 뽑겠습니다.");
		for(int i = 0; i < INIT_RECEIVE_CARD_COUNT; i++){
			for(Player player : players){
				player.receiveCard(cardDeck.draw());
			}
		}
	}
}
