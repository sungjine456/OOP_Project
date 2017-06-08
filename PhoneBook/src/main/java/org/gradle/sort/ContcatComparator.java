package org.gradle.sort;

import java.util.Comparator;

import org.gradle.common.SortUtils;
import org.gradle.domain.Contcat;

public class ContcatComparator implements Comparator<Contcat> {
	@Override
	public int compare(Contcat contcat1, Contcat contcat2) {
		return SortUtils.sort(contcat1.getName(), contcat2.getName());
	}
}
