package org.gradle.domain;

import java.util.ArrayList;
import java.util.List;

public class Group {
	private String groupName;
	private List<Contcat> contcats;
	
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
}
