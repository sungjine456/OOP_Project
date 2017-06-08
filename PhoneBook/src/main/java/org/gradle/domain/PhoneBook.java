package org.gradle.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gradle.common.StringUtils;
import org.gradle.common.Utils;
import org.gradle.exception.AlreadyGroupNameException;
import org.gradle.exception.FailNumberException;
import org.gradle.sort.GroupNameComparator;

public class PhoneBook {
	private Map<String, Group> groups;
	private final String DEFAULT_GROUP = "default";
	private final String SPAM_GROUP = "spam";

	public PhoneBook() {
		groups = new HashMap<>();
		addGroup(DEFAULT_GROUP);
		addGroup(SPAM_GROUP);
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
	
	public List<String> getGroupKeys(){
		List<String> list = new ArrayList<>();
		groups.keySet().stream().forEach(s -> list.add(s));
		Collections.sort(list, new GroupNameComparator());
		return list;
	}
	
	public void addGroup(String key){
		if(StringUtils.isEmpty(key)){
			throw new NullPointerException();
		}
		groups.put(key, new Group(key));
	}
	
	public void groupKeyChange(String key, String changeKey){
		if(StringUtils.isEmpty(key) || StringUtils.isEmpty(changeKey)){
			throw new NullPointerException();
		}
		if(hasGroupName(changeKey)){
			throw new AlreadyGroupNameException();
		}
		Group group = groups.remove(key);
		group.setGroupName(changeKey);
		groups.put(changeKey, group);
	}
	
	public List<Group> searchGroup(String word){
		if(StringUtils.isEmpty(word)){
			return new ArrayList<>();
		}
		List<Group> groupList = new ArrayList<>();
		getGroupKeys().stream()
					.filter(key -> key.contains(word))
					.forEach(key -> groupList.add(groups.get(key)));
		return groupList;
	}
	
	public List<Contcat> allContcatList(){
		List<Contcat> contcatList = new ArrayList<>();
		getGroupKeys().stream()
					.forEach(key -> contcatList.addAll(groups.get(key).getContcats()));
		return contcatList;
	}
	
	private boolean hasGroupName(String groupName){
		return groups.containsKey(groupName);
	}
	
	public void addContcat(String groupName, String name, String number){
		Group group = getGroup(groupName);
		if(!Utils.numberCheck(number)){
			throw new FailNumberException();
		}
		group.addContcat(name, number);
	}

	public List<Contcat> searchContCat(String word) {
		if(StringUtils.isEmpty(word)){
			return new ArrayList<>();
		}
		List<Contcat> contcatList = new ArrayList<>();
		getGroupKeys().stream()
				.forEach(key -> contcatList.addAll(groups.get(key).searchContcat(word)));
		return contcatList;
	}

	public void deleteContcat(String groupName, String name, String number) {
		Group group = getGroup(groupName);
		if(!Utils.numberCheck(number)){
			throw new FailNumberException();
		}
		group.deleteContcat(name, number);
	}
}
