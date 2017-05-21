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
}
