package org.gradle.domain;

public class Friend {
	private final String id;
	private final Contcat contcat;
	
	public Friend(String id, Contcat contcat){
		this.id = id;
		this.contcat = contcat;
	}

	public String getId() {
		return id;
	}
	public Contcat getContcat() {
		return contcat;
	}
	
	@Override
	public int hashCode(){
		int prime = 31;
		int result = 1;
		result = prime * result + contcat.hashCode();
		result = prime * result + id.hashCode();
		return result;
	}
	@Override
	public boolean equals(Object o){
		if(o==this) return true;
		if(!(o instanceof Friend)) return false;
		Friend user = (Friend)o;
		return user.getId().equals(id) && user.getContcat().equals(contcat);
	}
	@Override
	public String toString(){
		return "id : " + id + ", " + contcat;
	}
}
