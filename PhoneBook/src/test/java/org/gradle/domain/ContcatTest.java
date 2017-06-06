package org.gradle.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.gradle.exception.FailNumberException;
import org.junit.Before;
import org.junit.Test;

public class ContcatTest {
	
	private Contcat contcat;
	
	@Before
	public void setUp(){
		contcat = new Contcat("sungjin", "010-1234-1234");
	}

	@Test(expected=NullPointerException.class)
	public void constructorNumberNullTest() {
		contcat = new Contcat("sungjin", null);
	}

	@Test(expected=FailNumberException.class)
	public void constructorNumberFailTest() {
		contcat = new Contcat("sungjin", "12341234123");
	}

	@Test(expected=NullPointerException.class)
	public void constructorNameNullTest() {
		contcat = new Contcat(null, "010-1234-1234");
	}
	
	@Test
	public void isExistWordTest(){
		assertFalse(contcat.isExistWord("hong"));
		assertFalse(contcat.isExistWord("9999"));
		assertFalse(contcat.isExistWord("1235"));
		assertTrue(contcat.isExistWord("sung"));
		assertTrue(contcat.isExistWord("ng"));
		assertTrue(contcat.isExistWord("jin"));
		assertTrue(contcat.isExistWord("010-"));
		assertTrue(contcat.isExistWord("1234"));
	}
	
	@Test
	public void soltTest(){
		List<Contcat> list = new ArrayList<>();
		list.add(new Contcat("가", "010-0000-0000"));
		list.add(new Contcat("김", "010-0000-0000"));
		list.add(new Contcat("a", "010-0000-0000"));
		list.add(new Contcat("A", "010-0000-0000"));
		list.add(new Contcat("z", "010-0000-0000"));
		list.add(new Contcat("한", "010-0000-0000"));
		list.add(new Contcat("하", "010-0000-0000"));
		list.add(new Contcat("Z", "010-0000-0000"));
		list.add(new Contcat("가a", "010-0000-0000"));
		list.add(new Contcat("가김", "010-0000-0000"));
		list.add(new Contcat("&", "010-0000-0000"));
		Collections.sort(list);
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
