package org.gradle.domain;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
	private List<Group> groups;

	public PhoneBook() {
		groups = new ArrayList<>();
	}

	public List<Group> getGroups() {
		return groups;
	}
}
