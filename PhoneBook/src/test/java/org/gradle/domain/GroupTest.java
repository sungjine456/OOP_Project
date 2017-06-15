package org.gradle.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GroupTest {

	private Group group;
	
	@Before
	public void setUp(){
		group = new Group("default");
	}
	
	@Test
	public void addContcatTest() {
		group.addContcat(new Contcat("name", "010-1234-1234"));
	}
	
	@Test
	public void searchContcatNameTest(){
		group.addContcat(new Contcat("name", "010-1234-1234"));
		group.addContcat(new Contcat("names", "010-1234-1234"));
		group.addContcat(new Contcat("name1", "010-1234-1234"));
		group.addContcat(new Contcat("na", "010-1234-1234"));
		group.addContcat(new Contcat("nami", "010-1234-1234"));
		group.addContcat(new Contcat("sungjin", "010-1234-1234"));
		group.addContcat(new Contcat("hong", "010-1234-1234"));
		group.addContcat(new Contcat("kim", "010-1234-1234"));
		group.addContcat(new Contcat("kim dong 동", "010-9999-9999"));
		group.addContcat(new Contcat("kim me!", "010-1234-1234"));
		
		assertThat(group.searchContcat("na").size(), is(5));
		assertThat(group.searchContcat("m").size(), is(7));
		assertThat(group.searchContcat("sungjin").size(), is(1));
		assertThat(group.searchContcat("kim").size(), is(3));
		assertThat(group.searchContcat(" ").size(), is(2));
		assertThat(group.searchContcat("!").size(), is(1));
		
		List<Contcat> contcats = group.searchContcat("동");
		assertThat(contcats.size(), is(1));
		assertThat(contcats.get(0).getNumber(), is("010-9999-9999"));
	}
	
	@Test
	public void searchContcatNumberTest(){
		group.addContcat(new Contcat("name1", "010-1234-1234"));
		group.addContcat(new Contcat("name2", "010-1234-1231"));
		group.addContcat(new Contcat("name3", "010-1234-2275"));
		group.addContcat(new Contcat("name4", "010-1344-1554"));
		group.addContcat(new Contcat("name5", "010-1112-9595"));
		group.addContcat(new Contcat("name6", "010-1453-8935"));
		group.addContcat(new Contcat("name7", "010-6673-7345"));
		group.addContcat(new Contcat("name8", "010-2367-4674"));
		group.addContcat(new Contcat("name9", "010-3456-2345"));
		group.addContcat(new Contcat("name10", "010-4460-7667"));
		
		assertThat(group.searchContcat("010-").size(), is(10));
		assertThat(group.searchContcat("010-1").size(), is(6));
		assertThat(group.searchContcat("010-12").size(), is(3));
		assertThat(group.searchContcat("010-6").size(), is(1));
		assertThat(group.searchContcat("010-2367").size(), is(1));
		assertThat(group.searchContcat("010-1234").size(), is(3));
		assertThat(group.searchContcat("010-1234-123").size(), is(2));
		
		List<Contcat> contcats = group.searchContcat("010-1234-1231");
		assertThat(contcats.size(), is(1));
		assertThat(contcats.get(0).getName(), is("name2"));
	}
	
	@Test
	public void contcatSizeTest(){
		assertThat(group.contcatSize(), is(0));
		group.addContcat(new Contcat("name", "010-0000-4444"));
		assertThat(group.contcatSize(), is(1));
	}
	
	@Test
	public void deleteContcatTest(){
		assertThat(group.contcatSize(), is(0));
		group.addContcat(new Contcat("name", "010-0000-0000"));
		group.addContcat(new Contcat("name", "010-0000-0001"));
		group.addContcat(new Contcat("name", "010-0000-0002"));
		assertThat(group.contcatSize(), is(3));
		group.deleteContcat(new Contcat("name", "010-0000-0000"));
		assertThat(group.contcatSize(), is(2));
	}
	
	@Test
	public void getContcatsSortTest(){
		group.addContcat(new Contcat("A", "010-0000-0000"));
		group.addContcat(new Contcat("김", "010-0000-0000"));
		group.addContcat(new Contcat("a", "010-0000-0000"));
		group.addContcat(new Contcat("가", "010-0000-0000"));
		group.addContcat(new Contcat("z", "010-0000-0000"));
		group.addContcat(new Contcat("한", "010-0000-0000"));
		group.addContcat(new Contcat("하", "010-0000-0000"));
		group.addContcat(new Contcat("가a", "010-0000-0000"));
		group.addContcat(new Contcat("Z", "010-0000-0000"));
		group.addContcat(new Contcat("가김", "010-0000-0000"));
		group.addContcat(new Contcat("&", "010-0000-0000"));
		List<Contcat> list = group.getContcats();
		assertThat(list.get(0).getName(), is("가"));
		assertThat(list.get(1).getName(), is("가김"));
		assertThat(list.get(2).getName(), is("가a"));
		assertThat(list.get(3).getName(), is("김"));
		assertThat(list.get(4).getName(), is("하"));
		assertThat(list.get(5).getName(), is("한"));
		assertThat(list.get(6).getName(), is("A"));
		assertThat(list.get(7).getName(), is("Z"));
		assertThat(list.get(8).getName(), is("a"));
		assertThat(list.get(9).getName(), is("z"));
		assertThat(list.get(10).getName(), is("&"));
	}
}
