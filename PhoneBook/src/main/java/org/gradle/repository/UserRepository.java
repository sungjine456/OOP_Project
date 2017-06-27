package org.gradle.repository;

import java.util.HashMap;
import java.util.Map;

import org.gradle.domain.Contcat;
import org.gradle.domain.Friend;
import org.gradle.domain.User;

public class UserRepository {
	private static Map<String, User> data = new HashMap<>();
	
	private static UserRepository thisRepository;
	
	private UserRepository(){}
	
	public static UserRepository getInstance(){
		if(thisRepository == null){
			thisRepository = new UserRepository();
		}
		return thisRepository;
	}
	
	static {
		data.put("sungjin", new User("sungjin", "123123", new Contcat("sungjins", "010-0000-1111")));
		data.put("user", new User("user", "123123", new Contcat("hong", "010-0000-2222")));
		User user = new User("admin", "123123", new Contcat("jodan", "010-0000-3333"));
		user.addFriend(new Friend("sungjin", data.get("sungjin").getContcat()));
		data.put("admin", user);
	}
	
	public void save(User user){
		data.put(user.getId(), user);
	}
	
	public User find(String id){ 
		return data.get(id);
	}
}
