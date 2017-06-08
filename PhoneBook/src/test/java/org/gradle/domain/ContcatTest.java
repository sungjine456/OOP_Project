package org.gradle.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
}
