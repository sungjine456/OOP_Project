package org.gradle.domain;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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
		
		String[] s = {"1","2","3"};
		assertEquals("3S 0B", referee.confirmAnswer(s));
		String[] s1 = {"2","3","1"};
		assertEquals("0S 3B", referee.confirmAnswer(s1));
		String[] s2 = {"4","2","1"};
		assertEquals("1S 1B", referee.confirmAnswer(s2));
	}
	
	@Test
	public void showAnswerTest() throws Exception {
		Class<Referee> clazz = Referee.class;
		Constructor<?>[] cons = clazz.getConstructors();
		Constructor<?> reCon = cons[0];
		Field field = clazz.getDeclaredField("numberList");
		field.setAccessible(true);
		Referee referee = (Referee)reCon.newInstance(10);
		field.set(referee, Arrays.asList(1,2,3));
		
		assertEquals("1 2 3 ", referee.showAnswer());
	}
	
	@Test
	public void shuffleTest() throws Exception {
		List<Integer> numberList = new ArrayList<>();
		IntStream.range(0, 10).forEach(i->numberList.add(i));
		
		Class<Referee> clazz = Referee.class;
		Constructor<?>[] cons = clazz.getConstructors();
		Constructor<?> reCon = cons[0];
		Field field = clazz.getDeclaredField("numberList");
		field.setAccessible(true);
		Method method = clazz.getDeclaredMethod("shuffle", new Class[]{Integer.TYPE});
		method.setAccessible(true);
		Referee referee = (Referee)reCon.newInstance(10);
		field.set(referee, numberList);
		
		assertEquals("0 1 2 3 4 5 6 7 8 9 ", referee.showAnswer());
		method.invoke(referee, new Object[]{3});
		
		String result = referee.showAnswer();
		assertEquals(6, result.length());
		assertEquals(5, result.trim().length());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void setNumberListTest() throws Exception {
		Class<Referee> clazz = Referee.class;
		Constructor<?>[] cons = clazz.getConstructors();
		Constructor<?> reCon = cons[0];
		Field field = clazz.getDeclaredField("numberList");
		field.setAccessible(true);
		Method shuffleMethod = clazz.getDeclaredMethod("shuffle", new Class[]{Integer.TYPE});
		shuffleMethod.setAccessible(true);
		Method setNumberListMethod = clazz.getDeclaredMethod("setNumberList", new Class[]{Integer.TYPE});
		setNumberListMethod.setAccessible(true);
		Referee referee = (Referee)reCon.newInstance(10);
		
		List<Integer> list = (List<Integer>) field.get(referee);
		assertEquals(10, list.size());
		shuffleMethod.invoke(referee, new Object[]{3});
		setNumberListMethod.invoke(referee, new Object[]{3});
		
		list = (List<Integer>) field.get(referee);
		assertEquals(3, list.size());
	}
}
