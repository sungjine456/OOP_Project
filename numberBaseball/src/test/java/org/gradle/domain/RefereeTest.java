package org.gradle.domain;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

import org.junit.Test;

public class RefereeTest {
	@Test
	public void confirmAnswerTest() throws Exception {
		Class<Referee> clazz = Referee.class;
		Constructor<?>[] cons = clazz.getConstructors();
		Constructor<?> reCon = cons[0];
		Field field = clazz.getDeclaredField("numberList");
		field.setAccessible(true);
		Referee referee = (Referee)reCon.newInstance(10);
		field.set(referee, Arrays.asList(1,2,3));
		assertEquals("1 2 3 ", referee.showAnswer());
		
		String[] s = {"1","2","3"};
		assertEquals("3S 0B", referee.confirmAnswer(s));
		String[] s1 = {"2","3","1"};
		assertEquals("0S 3B", referee.confirmAnswer(s1));
		String[] s2 = {"4","2","1"};
		assertEquals("1S 1B", referee.confirmAnswer(s2));
	}
}
