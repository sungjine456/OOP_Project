package org.gradle.sort;

import java.util.Comparator;

import org.gradle.common.SortUtils;

public class GroupNameComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		return SortUtils.sort(s1, s2);
	}
}
