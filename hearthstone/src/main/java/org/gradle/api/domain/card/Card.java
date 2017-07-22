package org.gradle.api.domain.card;

import org.gradle.api.domain.ability.Ability;
import org.gradle.api.domain.common.Mana;
import org.gradle.api.domain.player.Player;

public interface Card extends Mana {
	Ability useCard(Player player);
	boolean hasAbility();
}
