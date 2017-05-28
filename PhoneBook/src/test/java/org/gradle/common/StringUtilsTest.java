package org.gradle.common;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {
	
	@Test
	public void isEmptyTest(){
		assertTrue(StringUtils.isEmpty(null));
		assertTrue(StringUtils.isEmpty(""));
		assertTrue(StringUtils.isEmpty(" "));
		assertFalse(StringUtils.isEmpty("123"));
		assertFalse(StringUtils.isEmpty("asd"));
	}

	@Test
	public void isNotEmptyTest(){
		assertFalse(StringUtils.isNotEmpty(null));
		assertFalse(StringUtils.isNotEmpty(""));
		assertFalse(StringUtils.isNotEmpty(" "));
		assertTrue(StringUtils.isNotEmpty("123"));
		assertTrue(StringUtils.isNotEmpty("asd"));
	}
	
	@Test
	public void equalsTest(){
		assertFalse(StringUtils.equals(null, null));
		assertFalse(StringUtils.equals(null, "abc"));
		assertFalse(StringUtils.equals("abc", null));
		assertFalse(StringUtils.equals("abc", "123"));
		assertFalse(StringUtils.equals("abc", "ABC"));
		assertFalse(StringUtils.equals("abc", "aBc"));
		assertFalse(StringUtils.equals("abc", "abC"));
		assertFalse(StringUtils.equals("abc", "Abc"));
		assertFalse(StringUtils.equals("abc", " abc"));
		assertFalse(StringUtils.equals("abc", "abc "));
		assertTrue(StringUtils.equals("abc", "abc"));
	}
	
	@Test
	public void equalsIgnoreTest(){
		assertTrue(StringUtils.equalsIgnore(null, null));
		assertFalse(StringUtils.equalsIgnore(null, "abc"));
		assertFalse(StringUtils.equalsIgnore("abc", null));
		assertFalse(StringUtils.equalsIgnore("abc", "123"));
		assertTrue(StringUtils.equalsIgnore(" ", "   "));
		assertTrue(StringUtils.equalsIgnore("abc", "ABC"));
		assertTrue(StringUtils.equalsIgnore("abc", "aBc"));
		assertTrue(StringUtils.equalsIgnore("abc", "abC"));
		assertTrue(StringUtils.equalsIgnore("abc", "Abc"));
		assertTrue(StringUtils.equalsIgnore("abc", " abc"));
		assertTrue(StringUtils.equalsIgnore("abc", "abc "));
		assertTrue(StringUtils.equalsIgnore("abc", "abc"));
	}
}
