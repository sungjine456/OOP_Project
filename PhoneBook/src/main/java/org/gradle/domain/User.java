package org.gradle.domain;

import java.util.ArrayList;
import java.util.List;

public final class User {
	private final String id;
	private final String password;
	private final List<User> friends;
	private final PhoneBook phoneBook;
	private final Contcat contcat;
	
	public User(String id, String password, String name, String number){
		contcat = new Contcat(name, number);
		this.id = id;
		this.password = password;
		friends = new ArrayList<>();
		phoneBook = new PhoneBook();
	}
	
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getName(){
		return contcat.getName();
	}
	public String getNumber(){
		return contcat.getNumber();
	}
	public Contcat getContcat(){
		return contcat;
	}
	public List<User> getFriends() {
		return friends;
	}
	public PhoneBook getPhoneBook() {
		return phoneBook;
	}
	
	@Override
	public int hashCode(){
		int prime = 31;
		int result = 1;
		result = prime * result + contcat.hashCode();
		result = prime * result + id.hashCode();
		result = prime * result + password.hashCode();
		return result;
	}
	@Override
	public boolean equals(Object o){
		if(o==this) return true;
		if(!(o instanceof User)) return false;
		User user = (User)o;
		return user.getId().equals(id) && user.getPassword().equals(password) && user.getContcat().equals(contcat);
	}
	@Override
	public String toString(){
		return "id : " + id + ", contcat : [ " + contcat.toString() + " ]";
	}
}
