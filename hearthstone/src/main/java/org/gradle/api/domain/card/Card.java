package org.gradle.api.domain.card;

import org.gradle.api.domain.common.Ability;
import org.gradle.api.domain.common.Health;
import org.gradle.api.domain.common.Mana;
import org.gradle.api.domain.common.OffenseAndDefensePower;

public interface Card extends Mana, Ability, OffenseAndDefensePower, Health {
}
