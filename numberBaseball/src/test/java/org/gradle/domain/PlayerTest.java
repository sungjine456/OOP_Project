package org.gradle.domain;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	private Class<Player> clazz;
	private Constructor<?>[] cons;
	private Player player;
	
	@Before
	public void setup() throws Exception{
		clazz = Player.class;
		cons = clazz.getConstructors();
		player = (Player)cons[0].newInstance();
	}
	
	@Test
	public void confirmAnswerTest() throws Exception {
		Field field = clazz.getDeclaredField("numberList");
		field.setAccessible(true);
		field.set(player, Arrays.asList(1,2,3));
		
		String[] s = {"1","2","3"};
		assertEquals("3S 0B", player.confirmAnswer(s));
		String[] s1 = {"2","3","1"};
		assertEquals("0S 3B", player.confirmAnswer(s1));
		String[] s2 = {"4","2","1"};
		assertEquals("1S 1B", player.confirmAnswer(s2));
	}
	
	@Test
	public void showAnswerTest() throws Exception {
		Field field = clazz.getDeclaredField("numberList");
		field.setAccessible(true);
		field.set(player, Arrays.asList(1,2,3));
		
		assertEquals("1 2 3 ", player.showAnswer());
	}
}
