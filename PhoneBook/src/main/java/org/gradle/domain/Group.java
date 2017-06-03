package org.gradle.domain;

import java.util.ArrayList;
import java.util.List;

public class Group {
	private List<Contcat> contcats;
	
	public Group(){
		contcats = new ArrayList<>();
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
