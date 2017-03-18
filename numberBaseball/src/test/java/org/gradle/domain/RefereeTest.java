package org.gradle.domain;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
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
		referee = (Referee)cons[0].newInstance(3);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shuffleTest() throws Exception {
		List<Integer> numberList = new ArrayList<>();
		IntStream.range(0, 10).forEach(i->numberList.add(i));
		
		Field numberListField = clazz.getDeclaredField("numberList");
		numberListField.setAccessible(true);
		Field numberSizeField = clazz.getDeclaredField("numberSize");
		numberSizeField.setAccessible(true);
		Method method = clazz.getDeclaredMethod("shuffle", new Class[]{});
		method.setAccessible(true);
		numberListField.set(referee, numberList);
		numberSizeField.set(referee, 3);
		
		List<Integer> list = (List<Integer>) numberListField.get(referee);
		assertEquals(10, list.size());
		method.invoke(referee, new Object[]{});
		
		String[] result = referee.showAnswer().split(" ");
		assertEquals(3, result.length);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void setNumberListTest() throws Exception {
		Field numberListField = clazz.getDeclaredField("numberList");
		numberListField.setAccessible(true);
		Field numberSizeField = clazz.getDeclaredField("numberSize");
		numberSizeField.setAccessible(true);
		Method shuffleMethod = clazz.getDeclaredMethod("shuffle", new Class[]{});
		shuffleMethod.setAccessible(true);
		Method setNumberListMethod = clazz.getDeclaredMethod("setNumberList", new Class[]{});
		setNumberListMethod.setAccessible(true);
		numberSizeField.set(referee, 3);
		numberListField.set(referee, new ArrayList<>());
		
		List<Integer> list = (List<Integer>) numberListField.get(referee);
		assertEquals(0, list.size());
		setNumberListMethod.invoke(referee, new Object[]{});
		
		list = (List<Integer>) numberListField.get(referee);
		assertEquals(3, list.size());
	}
}
