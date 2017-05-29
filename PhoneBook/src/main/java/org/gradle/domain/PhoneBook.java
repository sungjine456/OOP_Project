package org.gradle.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.gradle.common.StringUtils;

public class PhoneBook {
	private Map<String, Group> groups;
	private final String DEFAULT_GROUP = "default";
	private final String SPAM_GROUP = "spam";

	public PhoneBook() {
		groups = new HashMap<>();
		groups.put(DEFAULT_GROUP, new Group());
		groups.put(SPAM_GROUP, new Group());
	}

	
	public Group getGroup() {
		return groups.get(DEFAULT_GROUP);
	}
	public Group getGroup(String key) {
		if(StringUtils.isEmpty(key)){
			return groups.get(DEFAULT_GROUP);
		}
		return groups.get(key);
	}
	public Set<String> getGroupKeys(){
		return groups.keySet();
	}
	public void addGroup(String key){
		groups.put(key, new Group());
	}
	public void groupKeyChange(String key, String changeKey){
		if(StringUtils.isEmpty(key) || StringUtils.isEmpty(changeKey)){
			throw new NullPointerException();
		}
		Group group = groups.remove(key);
		groups.put(changeKey, group);
	}
}
