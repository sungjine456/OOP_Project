package org.gradle.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.gradle.exception.FailNumberException;

public final class User {
	private final String id;
	private final String password;
	private final List<Friend> friends;
	private final PhoneBook phoneBook;
	private final Contcat contcat;
	
	public User(String id, String password, Contcat contcat) throws FailNumberException {
		this.contcat = contcat;
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
	public List<Friend> getFriends() {
		List<Friend> copyFriend = new ArrayList<>();
		copyFriend.addAll(friends);
		return copyFriend;
	}
	public PhoneBook getPhoneBook() {
		return phoneBook;
	}
	
	public boolean hasFriend(String id){
		return findFriend(id)!=null;
	}
	public void addFriend(Friend friend){
		friends.add(friend);
	}
	public void removeFriend(Friend friend){
		friends.remove(friend);
	}
	public List<Friend> findFriends(String id){
		return friends.stream()
					.filter(friend -> friend.getId().contains(id))
					.collect(Collectors.toList());
	}
	public Friend findFriend(String id){
		return friends.stream()
				.filter(friend -> friend.getId().equals(id)).findAny().orElse(null);
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
		return "id : " + id + ", " + contcat.toString();
	}
}
