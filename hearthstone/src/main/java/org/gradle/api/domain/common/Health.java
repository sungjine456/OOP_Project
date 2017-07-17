package org.gradle.api.domain.common;

public interface Health {
	boolean isDead();
	int getHealth();
	void beAttack(int attack);
	void beCure(int cure);
}
