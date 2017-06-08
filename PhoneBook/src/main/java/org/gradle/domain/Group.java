package org.gradle.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import org.gradle.sort.ContcatComparator;

public class Group {
	private String groupName;
	private final List<Contcat> contcats;
	
	public Group(String groupName){
		this.groupName = groupName;
		contcats = new ArrayList<>();
	}

	public String getGroupName(){
		return groupName;
	}
	public void setGroupName(String changeKey) {
		groupName = changeKey;
	}
	public List<Contcat> getContcats() {
		Collections.sort(contcats, new ContcatComparator());
		return contcats;
	}
	public void addContcat(String name, String number){
		contcats.add(new Contcat(name, number));
	}
	public void deleteContcat(String name, String number){
		contcats.remove(new Contcat(name, number));
	}
	public List<Contcat> searchContcat(String word){
		List<Contcat> searchContcats = new ArrayList<>();
		getContcats().stream()
				.filter(contcat -> contcat.isExistWord(word))
				.forEach(contcat -> searchContcats.add(contcat));
		return searchContcats;
	}
	public int contcatSize(){
		return contcats.size();
	}
	
	@Override
	public int hashCode(){
		int prime = 31;
		int result = 1;
		result = prime * result + groupName.hashCode();
		return result;
	}
	@Override
	public boolean equals(Object o){
		if(o==this) return true;
		if(!(o instanceof Group)) return false;
		Group group = (Group)o;
		List<Contcat> contcatList = getContcats();
		List<Contcat> otherContcatList = group.getContcats();
		int len = contcats.size();
		if(otherContcatList.size() != len) return false;
		long count = IntStream.range(0, len)
							.filter(i -> otherContcatList.get(i).equals(contcatList.get(i)))
							.count();
		return count==len && group.getGroupName().equals(groupName);
	}
	@Override
	public String toString(){
		return "groupName : " + groupName + ", contcat size : " + contcats.size();
	}
}
