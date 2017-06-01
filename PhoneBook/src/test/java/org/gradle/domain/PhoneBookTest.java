package org.gradle.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

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
	
	@Test
	public void searchGroupTest(){
		phoneBook.addGroup("친구들");
		phoneBook.addGroup("family");
		phoneBook.addGroup("freinds");
		phoneBook.addGroup("customer");
		phoneBook.addGroup("office");
		
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
}
