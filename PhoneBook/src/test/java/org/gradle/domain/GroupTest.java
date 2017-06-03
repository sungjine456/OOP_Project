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
		group = new Group();
	}
	
	@Test
	public void addContcatTest() {
		group.addContcat("name", "010-1234-1234");
	}
	
	@Test
	public void searchNameTest(){
		group.addContcat("name", "010-1234-1234");
		group.addContcat("names", "010-1234-1234");
		group.addContcat("name1", "010-1234-1234");
		group.addContcat("na", "010-1234-1234");
		group.addContcat("nami", "010-1234-1234");
		group.addContcat("sungjin", "010-1234-1234");
		group.addContcat("hong", "010-1234-1234");
		group.addContcat("kim", "010-1234-1234");
		group.addContcat("kim dong 동", "010-9999-9999");
		group.addContcat("kim me!", "010-1234-1234");
		
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
	public void searchNumberTest(){
		group.addContcat("name1", "010-1234-1234");
		group.addContcat("name2", "010-1234-1231");
		group.addContcat("name3", "010-1234-2275");
		group.addContcat("name4", "010-1344-1554");
		group.addContcat("name5", "010-1112-9595");
		group.addContcat("name6", "010-1453-8935");
		group.addContcat("name7", "010-6673-7345");
		group.addContcat("name8", "010-2367-4674");
		group.addContcat("name9", "010-3456-2345");
		group.addContcat("name10", "010-4460-7667");
		
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
		group.addContcat("name", "010-0000-4444");
		assertThat(group.contcatSize(), is(1));
	}
}
