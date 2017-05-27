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
}
