package org.gradle.common;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void changeStringIsNumberTest() {
		assertEquals(Utils.changeStringIsNumber("1"), 1);
		assertEquals(Utils.changeStringIsNumber("2"), 2);
		assertEquals(Utils.changeStringIsNumber("99"), 99);
		assertEquals(Utils.changeStringIsNumber("a"), -1);
	}
	
	@Test
	public void numberCheckTest(){
		assertFalse(Utils.numberCheck("1"));
		assertFalse(Utils.numberCheck("3=3=3"));
		assertFalse(Utils.numberCheck("3-3-3"));
		assertFalse(Utils.numberCheck("123-123-12"));
		assertFalse(Utils.numberCheck("123-123-12aa"));
		assertFalse(Utils.numberCheck("123-123a-12"));
		assertFalse(Utils.numberCheck("123a-123-12"));
		assertFalse(Utils.numberCheck("123-1234-1234"));
		assertFalse(Utils.numberCheck("010-1234-124"));
		assertTrue(Utils.numberCheck("010-1234-1234"));
		assertTrue(Utils.numberCheck("010-123-1234"));
	}
}
