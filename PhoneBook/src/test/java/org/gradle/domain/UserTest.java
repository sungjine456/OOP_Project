package org.gradle.domain;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	private User user;
	
	@Before
	public void setUp(){
		user = new User("sungjin", "123123", new Contcat("sung", "010-1234-1234"));
	}
	
	@Test
	public void hasFriendTest(){
		assertFalse(user.hasFriend("user"));
		user.addFriend(new Friend("user", new Contcat("user", "010-1234-1243")));
		assertTrue(user.hasFriend("user"));
		user.removeFriend(new Friend("user", new Contcat("user", "010-1234-1243")));
		assertFalse(user.hasFriend("user"));
	}
	
	@Test
	public void addFriendTest(){
		assertNull(user.findFriend("user"));
		user.addFriend(new Friend("user", new Contcat("user", "010-1234-1243")));
		assertNotNull(user.findFriend("user"));
	}
	@Test
	public void removeFriendTest(){
		assertFalse(user.hasFriend("user"));
		user.addFriend(new Friend("user", new Contcat("user", "010-1234-1243")));
		assertTrue(user.hasFriend("user"));
		user.removeFriend(new Friend("user", new Contcat("user", "010-1234-1243")));
		assertFalse(user.hasFriend("user"));
	}
	@Test
	public void findFriendsTest(){
		assertThat(user.findFriends("user")).isEmpty();
		Friend friend = new Friend("user", new Contcat("user", "010-1234-1243"));
		Friend friend1 = new Friend("user1", new Contcat("user1", "010-1234-1243"));
		user.addFriend(friend);
		user.addFriend(friend1);
		assertThat(user.findFriends("user")).hasSize(2)
											.contains(friend, friend1);
	}
	@Test
	public void findFriendTest(){
		assertThat(user.findFriend("user")).isNull();
		Friend friend = new Friend("user", new Contcat("user", "010-1234-1243"));
		Friend friend1 = new Friend("user1", new Contcat("user1", "010-1234-1243"));
		user.addFriend(friend);
		user.addFriend(friend1);
		assertThat(user.findFriend("user")).isNotNull();
	}
}
