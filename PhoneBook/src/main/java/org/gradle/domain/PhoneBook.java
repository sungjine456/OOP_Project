package org.gradle.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
	private Map<String, Group> groups;

	public PhoneBook() {
		groups = new HashMap<>();
	}

	public Group getGroup(String key) {
		return groups.get(key);
	}
	public Set<String> getGroupKeys(){
		return groups.keySet();
	}
	public void addGroup(String key){
		groups.put(key, new Group());
	}
	public void groupKeyChange(String key, String changeKey){
		Group group = groups.remove(key);
		groups.put(changeKey, group);
	}
}
