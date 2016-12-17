package org.gradle.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Game {
	private static final int INIT_RECEIVE_CARD_COUNT = 2;
	
	public void play(){
		System.out.println("Hello Blackjack Game");
		Scanner sc = new Scanner(System.in);
		CardDeck cardDeck = new CardDeck();
		Gamer gamer = new Gamer();
		Dealer dealer = new Dealer();
		Rule rule = new Rule();
		
		List<Player> players = Arrays.asList(gamer, dealer);
		
		initPhase(cardDeck, players);
		playingPhase(sc, cardDeck, players);
	}
	
	private void playingPhase(Scanner sc, CardDeck cardDeck, List<Player> players){
		String playerInput;
		boolean isGamerTurnOff = false;
		boolean isDealerTurnOff = false;
		while(true){
			for(Player player : players){
				System.out.println("카드를 뽑아주세요.(0을 누르면 종료됩니다.)");
				playerInput = sc.nextLine();
				if("0".equals(playerInput)){
					if(player instanceof Gamer){
						isGamerTurnOff = true;
					} else {
						isDealerTurnOff = true;
					}
				} else {
					if(player instanceof Gamer && !isGamerTurnOff){
						player.receiveCard(cardDeck.draw());
					} 
					if(player instanceof Dealer && !isDealerTurnOff){
						player.receiveCard(cardDeck.draw());
					}
				}
			}
			
			if(isGamerTurnOff && isDealerTurnOff){
				break;
			}
		}
	}
	
	private void initPhase(CardDeck cardDeck, List<Player> players){
		System.out.println("처음 2장을 뽑겠습니다.");
		players.forEach(player -> {
			IntStream.range(0, INIT_RECEIVE_CARD_COUNT).forEach(i -> {
				player.receiveCard(cardDeck.draw());
			});
		});
	}
}
