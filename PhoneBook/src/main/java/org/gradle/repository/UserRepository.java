package org.gradle.repository;

import java.util.HashMap;
import java.util.Map;

import org.gradle.domain.User;

public class UserRepository {
	private static Map<String, User> data = new HashMap<>();
	
	private static UserRepository thisRepository;
	
	private UserRepository(){
		initData();
	}
	
	public static UserRepository getInstance(){
		if(thisRepository == null){
			thisRepository = new UserRepository();
		}
		return thisRepository;
	}
	
	private void initData(){
		data.put("sungjin", new User("sungjin", "123123", "sungjins", "010-0000-1111"));
		data.put("user", new User("user", "123123", "hong", "010-0000-2222"));
		data.put("admin", new User("admin", "123123", "jodan", "010-0000-3333"));
	}
	
	public void save(User user){
		data.put(user.getId(), user);
	}
	
	public User find(String id){ 
		return data.get(id);
	}
}
