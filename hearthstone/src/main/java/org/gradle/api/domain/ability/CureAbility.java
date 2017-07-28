package org.gradle.api.domain.ability;

import org.gradle.api.domain.common.Health;

public class CureAbility implements Ability {
	
	private final int cure;
	
	public CureAbility(int cure){
		this.cure = cure;
	}

	@Override
	public void useAbility(Health health) {
		health.beCure(cure);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cure;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CureAbility other = (CureAbility) obj;
		if (cure != other.cure)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CureAbility [cure=" + cure + "]";
	}
}
