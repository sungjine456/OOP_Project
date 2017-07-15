package org.gradle.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.gradle.common.StringUtils;
import org.gradle.exception.AlreadyGroupNameException;
import org.gradle.exception.CanNotBeChangedException;
import org.gradle.exception.FailNumberException;
import org.gradle.sort.GroupNameComparator;

public class PhoneBook {
	private final Map<String, Group> groups;
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
		return groups.keySet().stream()
							.sorted(new GroupNameComparator())
							.collect(Collectors.toList());
	}
	
	public void addGroup(String key) throws AlreadyGroupNameException {
		if(StringUtils.isEmpty(key)){
			throw new NullPointerException();
		}
		if(hasGroupName(key)){
			throw new AlreadyGroupNameException(key);
		}
		groups.put(key, new Group(key));
	}
	
	public void groupNameChange(String groupName, String changeGroupName) throws AlreadyGroupNameException, CanNotBeChangedException {
		if(isNotChangeGroupName(changeGroupName)){
			throw new AlreadyGroupNameException(changeGroupName);
		}
		Group group = groups.remove(groupName);
		group.setGroupName(changeGroupName);
		groups.put(changeGroupName, group);
	}
	
	public List<Group> searchGroup(String word){
		if(StringUtils.isEmpty(word)){
			return new ArrayList<>();
		}
		return getGroupKeys().stream()
					.filter(key -> key.contains(word))
					.map(key -> groups.get(key))
					.collect(Collectors.toList());
	}
	
	public List<Contcat> allContcatList(){
		return getGroupKeys().stream()
							.flatMap(key -> groups.get(key).getContcats().stream())
							.collect(Collectors.toList());
	}
	
	public boolean hasGroupName(String groupName){
		return groups.containsKey(groupName);
	}
	
	public void addContcat(String groupName, Contcat contcat) throws FailNumberException {
		Group group = getGroup(groupName);
		group.addContcat(contcat);
	}

	public List<Contcat> searchContCat(String word) {
		if(StringUtils.isEmpty(word)){
			return new ArrayList<>();
		}
		return getGroupKeys().stream()
							.flatMap(key -> groups.get(key).searchContcat(word).stream())
							.collect(Collectors.toList());
	}

	public void deleteContcat(String groupName, Contcat contcat) {
		Group group = getGroup(groupName);
		group.deleteContcat(contcat);
	}
	
	private boolean isNotChangeGroupName(String groupName){
		if(StringUtils.isEmpty(groupName)){
			return true;
		}
		return hasGroupName(groupName);
	}
}
