package org.gradle.api.domain.common;

public interface Health {
	boolean isDead();
	int remainingHealth();
	void beAttack(int attack);
	void beCure(int cure);
}
