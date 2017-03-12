package org.gradle.domain;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

public class RefereeTest {
	private Class<Referee> clazz;
	private Constructor<?>[] cons;
	private Referee referee;
	
	@Before
	public void setup() throws Exception{
		clazz = Referee.class;
		cons = clazz.getConstructors();
		referee = (Referee)cons[0].newInstance(10);
	}
	
	@Test
	public void confirmAnswerTest() throws Exception {
		Field field = clazz.getDeclaredField("numberList");
		field.setAccessible(true);
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
		Field field = clazz.getDeclaredField("numberList");
		field.setAccessible(true);
		field.set(referee, Arrays.asList(1,2,3));
		
		assertEquals("1 2 3 ", referee.showAnswer());
	}
	
	@Test
	public void shuffleTest() throws Exception {
		List<Integer> numberList = new ArrayList<>();
		IntStream.range(0, 10).forEach(i->numberList.add(i));
		
		Field field = clazz.getDeclaredField("numberList");
		field.setAccessible(true);
		Method method = clazz.getDeclaredMethod("shuffle", new Class[]{Integer.TYPE});
		method.setAccessible(true);
		field.set(referee, numberList);
		
		assertEquals("0 1 2 3 4 5 6 7 8 9 ", referee.showAnswer());
		method.invoke(referee, new Object[]{3});
		
		String[] result = referee.showAnswer().split(" ");
		assertEquals(3, result.length);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void setNumberListTest() throws Exception {
		Field field = clazz.getDeclaredField("numberList");
		field.setAccessible(true);
		Method shuffleMethod = clazz.getDeclaredMethod("shuffle", new Class[]{Integer.TYPE});
		shuffleMethod.setAccessible(true);
		Method setNumberListMethod = clazz.getDeclaredMethod("setNumberList", new Class[]{Integer.TYPE});
		setNumberListMethod.setAccessible(true);
		Referee referee = (Referee)cons[1].newInstance();
		
		List<Integer> list = (List<Integer>) field.get(referee);
		assertEquals(0, list.size());
		setNumberListMethod.invoke(referee, new Object[]{3});
		
		list = (List<Integer>) field.get(referee);
		assertEquals(3, list.size());
	}
}
