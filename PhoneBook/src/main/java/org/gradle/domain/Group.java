package org.gradle.domain;

import java.util.ArrayList;
import java.util.List;

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
		for(Contcat contcat : contcats){
			if(contcat.isExistWord(word)){
				searchContcats.add(contcat);
			}
		}
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
		List<Contcat> contcatList = group.getContcats();
		if(contcatList.size()!=contcats.size()) return false;
		int len = contcats.size();
		for(int i = 0; i < len; i++){
			if(!contcatList.get(i).equals(contcats.get(i))){
				return false;
			}
		}
		return group.getGroupName().equals(groupName);
	}
	@Override
	public String toString(){
		return "groupName : " + groupName + ", contcat size : " + contcats.size();
	}
}
