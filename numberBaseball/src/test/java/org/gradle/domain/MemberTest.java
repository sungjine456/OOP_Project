package org.gradle.domain;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MemberTest {
	private Class<Member> clazz;
	private Constructor<?>[] cons;
	private Member member;
	
	@Before
	public void setup() throws Exception{
		clazz = Member.class;
		cons = clazz.getConstructors();
		member = (Member)cons[0].newInstance(3);
	}
	
	@Test
	public void notSameNumberTest() throws Exception {
		Field field = clazz.getDeclaredField("numberList");
		field.setAccessible(true);
		Method method = clazz.getDeclaredMethod("notSameNumber", new Class[]{});
		method.setAccessible(true);
		
		field.set(member, makeList(1,2,3));
		assertTrue((boolean)method.invoke(member, new Object[]{}));

		field.set(member, makeList(1,2,2));
		assertFalse((boolean)method.invoke(member, new Object[]{}));
	}
	
	@Test
	public void parseNumbersTest() throws Exception {
		Method method = clazz.getDeclaredMethod("parseNumbers", new Class[]{String[].class});
		method.setAccessible(true);
		String[] str1 = {"1","2","3"};
		assertTrue((boolean)method.invoke(member, new Object[]{str1}));
		String[] str2 = {"1","b","2"};
		assertFalse((boolean)method.invoke(member, new Object[]{str2}));
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void setNumber() throws Exception {
		Field field = clazz.getDeclaredField("numberList");
		field.setAccessible(true);
		assertTrue(member.setNumber("125"));
		
		List<Integer> list = (LinkedList<Integer>)field.get(member);
		assertEquals(3, list.size());
		assertEquals(1, list.get(0).intValue());
		assertEquals(2, list.get(1).intValue());
		assertEquals(5, list.get(2).intValue());
	}
	
	private List<Integer> makeList(int... numbers){
		List<Integer> list = new LinkedList<>();
		for(int number : numbers){
			list.add(number);
		}
		return list;
	}
}
