package org.gradle.domain;

import java.util.ArrayList;
import java.util.List;

public class User extends Contcat {
	private String id;
	private String password;
	private List<User> friends;
	private PhoneBook phoneBook;
	
	public User(String id, String password, String name, String number){
		super(name, number);
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
	public List<User> getFriends() {
		return friends;
	}
	public PhoneBook getPhoneBook() {
		return phoneBook;
	}
}
