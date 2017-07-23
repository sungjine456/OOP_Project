package org.gradle.api.repository;

import java.util.ArrayList;
import java.util.List;

import org.gradle.api.domain.ability.AttackOnlyServantAbility;
import org.gradle.api.domain.ability.AttackServantOrHeroAbility;
import org.gradle.api.domain.ability.CureAbility;
import org.gradle.api.domain.ability.KillServantAbility;
import org.gradle.api.domain.card.Card;
import org.gradle.api.domain.card.MagicCard;
import org.gradle.api.domain.card.ServantCard;
import org.gradle.api.domain.card.WeaponCard;

public class CardRepository {
	private static final CardRepository INSTANCE = new CardRepository();
	private static List<Card> cardData = new ArrayList<>();
	
	private CardRepository(){}
	public static CardRepository getInstance(){
		return INSTANCE;
	}
	
	static {
		// Magic Card
		cardData.add(new MagicCard(1, new CureAbility(1)));
		cardData.add(new MagicCard(2, new CureAbility(2)));
		cardData.add(new MagicCard(3, new CureAbility(3)));
		cardData.add(new MagicCard(1, new AttackOnlyServantAbility(1)));
		cardData.add(new MagicCard(2, new AttackOnlyServantAbility(2)));
		cardData.add(new MagicCard(2, new AttackServantOrHeroAbility(1)));
		cardData.add(new MagicCard(3, new AttackServantOrHeroAbility(2)));
		cardData.add(new MagicCard(3, new KillServantAbility()));
		
		// Weapon Card
		cardData.add(new WeaponCard(2, 1, 3));
		cardData.add(new WeaponCard(2, 3, 1));
		cardData.add(new WeaponCard(4, 3, 3));
		cardData.add(new WeaponCard(4, 5, 1));
		
		// Servant Card none Ability
		cardData.add(new ServantCard(1, 1, 1));
		cardData.add(new ServantCard(2, 1, 1));
		cardData.add(new ServantCard(2, 2, 1));
		cardData.add(new ServantCard(2, 1, 2));
		cardData.add(new ServantCard(3, 2, 1));
		cardData.add(new ServantCard(3, 2, 2));
		cardData.add(new ServantCard(3, 1, 2));
		cardData.add(new ServantCard(4, 2, 2));
		cardData.add(new ServantCard(5, 2, 3));
		
		// Servant Card has Ability
		cardData.add(new ServantCard(3, 1, new CureAbility(1), 3));
		cardData.add(new ServantCard(4, 1, new CureAbility(2), 3));
		cardData.add(new ServantCard(5, 2, new CureAbility(2), 3));
		cardData.add(new ServantCard(6, 2, new CureAbility(2), 4));
		cardData.add(new ServantCard(7, 2, new CureAbility(3), 4));
		cardData.add(new ServantCard(3, 1, new KillServantAbility(), 1));
		cardData.add(new ServantCard(5, 1, new KillServantAbility(), 3));
		cardData.add(new ServantCard(7, 2, new KillServantAbility(), 4));
		cardData.add(new ServantCard(2, 1, new AttackServantOrHeroAbility(1), 1));
		cardData.add(new ServantCard(3, 1, new AttackServantOrHeroAbility(1), 2));
		cardData.add(new ServantCard(4, 2, new AttackServantOrHeroAbility(1), 3));
		cardData.add(new ServantCard(5, 2, new AttackServantOrHeroAbility(1), 4));
		cardData.add(new ServantCard(6, 2, new AttackServantOrHeroAbility(2), 5));
		cardData.add(new ServantCard(7, 2, new AttackServantOrHeroAbility(3), 6));
		cardData.add(new ServantCard(2, 1, new AttackOnlyServantAbility(1), 2));
		cardData.add(new ServantCard(3, 1, new AttackOnlyServantAbility(1), 3));
		cardData.add(new ServantCard(4, 2, new AttackOnlyServantAbility(2), 4));
		cardData.add(new ServantCard(5, 2, new AttackOnlyServantAbility(2), 5));
		cardData.add(new ServantCard(6, 2, new AttackOnlyServantAbility(3), 6));
		cardData.add(new ServantCard(7, 2, new AttackOnlyServantAbility(3), 7));
	}
	
	public int size(){
		return cardData.size();
	}
	public Card getCard(int index){
		return cardData.get(index).newCard();
	}
}
