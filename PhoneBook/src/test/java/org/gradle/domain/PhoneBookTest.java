package org.gradle.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.gradle.exception.AlreadyGroupNameException;
import org.junit.Before;
import org.junit.Test;

public class PhoneBookTest {
	private PhoneBook phoneBook;
	
	@Before
	public void setUp(){
		phoneBook = new PhoneBook();
		phoneBook.addGroup("친구");
	}
	
	@Test
	public void addGroupTest(){
		assertThat(phoneBook.getGroupKeys().size(), is(3));
		phoneBook.addGroup("addGroup");
		assertThat(phoneBook.getGroupKeys().size(), is(4));
	}

	@Test(expected = NullPointerException.class)
	public void addGroupEmptyKeyTest(){
		phoneBook.addGroup(" ");
	}

	@Test
	public void getGroupNoParamTest() {
		assertNotNull(phoneBook.getGroup());
	}

	@Test
	public void getGroupParamStringTest() {
		assertNotNull(phoneBook.getGroup(null));
		assertNotNull(phoneBook.getGroup(""));
		assertNotNull(phoneBook.getGroup("spam"));
		assertNull(phoneBook.getGroup("a"));
	}
	
	@Test
	public void groupKeyChangeSuccessTest(){
		assertNotNull(phoneBook.getGroup("친구"));
		
		phoneBook.groupKeyChange("친구", "친구들");
		
		assertNull(phoneBook.getGroup("친구"));
		assertNotNull(phoneBook.getGroup("친구들"));
	}
	
	@Test(expected=NullPointerException.class)
	public void groupKeyChangeNullKeyTest(){
		phoneBook.groupKeyChange(null, "친구들");
	}
	
	@Test(expected=NullPointerException.class)
	public void groupKeyChangeNullChangeKeyTest(){
		phoneBook.groupKeyChange("친구", null);
	}
	
	@Test(expected=AlreadyGroupNameException.class)
	public void groupKeyChangeAlreadyGroupNameTest(){
		phoneBook.groupKeyChange("친구", "default");
	}
	
	@Test
	public void searchGroupTest(){
		phoneBook.addGroup("친구들");
		phoneBook.addGroup("family");
		phoneBook.addGroup("freinds");
		phoneBook.addGroup("customer");
		phoneBook.addGroup("office");
		
		assertThat(phoneBook.searchGroup(null).size(), is(0));
		assertThat(phoneBook.searchGroup("").size(), is(0));
		assertThat(phoneBook.searchGroup(" ").size(), is(0));
		assertThat(phoneBook.searchGroup("b").size(), is(0));
		assertThat(phoneBook.searchGroup("d").size(), is(2));
		assertThat(phoneBook.searchGroup("친").size(), is(2));
		assertThat(phoneBook.searchGroup("f").size(), is(4)); // default 포함
		assertThat(phoneBook.searchGroup("a").size(), is(3)); // spam 포함
	}
	
	@Test
	public void allContcatListTest(){
		assertThat(phoneBook.allContcatList().size(),is(0));
		
		phoneBook.getGroup("default").addContcat("de", "010-1234-1234");
		phoneBook.getGroup("default").addContcat("fault", "010-1234-1234");
		phoneBook.getGroup("spam").addContcat("s", "010-1234-1234");
		phoneBook.getGroup("spam").addContcat("pam", "010-1234-1234");
		
		assertThat(phoneBook.allContcatList().size(),is(4));
	}
	
	@Test
	public void getGroupKeysTest(){
		List<String> list = phoneBook.getGroupKeys();
		assertNotNull(list);
		assertThat(list.size(), is(3));
		
		phoneBook.addGroup("friends");
		list = phoneBook.getGroupKeys();
		assertThat(list.size(), is(4));
	}
	
	@Test
	public void searchContcatTest(){
		Group defaultGroup = phoneBook.getGroup();
		defaultGroup.addContcat("name1", "010-0000-0000");
		defaultGroup.addContcat("name2", "010-0000-0001");
		defaultGroup.addContcat("name3", "010-0000-0002");
		defaultGroup.addContcat("name4", "010-0000-0003");
		defaultGroup.addContcat("name5", "010-0000-0004");
		Group spamGroup = phoneBook.getGroup("spam");
		spamGroup.addContcat("name6", "010-0000-0000");
		spamGroup.addContcat("name7", "010-0000-0011");
		spamGroup.addContcat("name8", "010-0000-0022");
		spamGroup.addContcat("name9", "010-0000-0033");
		spamGroup.addContcat("10", "010-0000-0044");
		
		assertThat(phoneBook.searchContCat(null).size(), is(0));
		assertThat(phoneBook.searchContCat("").size(), is(0));
		assertThat(phoneBook.searchContCat(" ").size(), is(0));
		assertThat(phoneBook.searchContCat("1").size(), is(10));
		assertThat(phoneBook.searchContCat("name").size(), is(9));
		assertThat(phoneBook.searchContCat("4").size(), is(3));
		assertThat(phoneBook.searchContCat("11").size(), is(1));
	}
	
	@Test
	public void addContcatTest(){
		assertThat(phoneBook.getGroup().contcatSize(), is(0));
		phoneBook.addContcat("", "name1", "010-0000-0000");
		assertThat(phoneBook.getGroup().contcatSize(), is(1));
	}
	
	@Test
	public void deleteContcatTest(){
		Group defaultGroup = phoneBook.getGroup();
		defaultGroup.addContcat("name", "010-0000-0000");
		assertThat(defaultGroup.contcatSize(), is(1));
		phoneBook.deleteContcat("", "name", "010-0000-0000");
		assertThat(defaultGroup.contcatSize(), is(0));
	}
}
