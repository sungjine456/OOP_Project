package org.gradle.api.domain.ability;

import org.gradle.api.domain.common.Health;

public interface Ability {
	void useAbility(Health health);
}
