package org.gradle.api.domain.card;

import org.gradle.api.domain.common.Health;
import org.gradle.api.domain.common.Mana;

public interface Card extends Mana {
	void useCard(Health heroOrServantCard);
	boolean hasAbility();
	Card newCard();
}
