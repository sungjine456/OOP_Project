package org.gradle.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

import org.gradle.domain.Player;
import org.gradle.domain.Referee;
import org.junit.Test;

public class GameServiceTest {
	
	@Test
	public void makeGameTestPramOneInt() throws Exception {
		Class<GameService> clazz = GameService.class;
		Constructor<?> con = clazz.getConstructor(new Class[]{});
		Field field = clazz.getDeclaredField("players");
		field.setAccessible(true);
		GameService service = (GameService) con.newInstance();
		
		assertNull(field.get(service));
		
		service.makeGame(3);
		Player[] players = (Player[])field.get(service);
		
		assertEquals(1, players.length);
	}

	@Test
	public void makeGameTestPramsTwoInt() throws Exception {
		Class<GameService> clazz = GameService.class;
		Constructor<?> con = clazz.getConstructor(new Class[]{});
		Field field = clazz.getDeclaredField("players");
		field.setAccessible(true);
		GameService service = (GameService) con.newInstance();
		
		assertNull(field.get(service));
		
		service.makeGame(3, 2);
		Player[] players = (Player[])field.get(service);
		
		assertEquals(2, players.length);
	}
	
	@Test
	public void getAnswerTest() throws Exception {
		Class<Referee> refClazz = Referee.class;
		Constructor<?>[] cons = refClazz.getConstructors();
		Constructor<?> reCon = cons[0];
		Field numberListField = refClazz.getDeclaredField("numberList");
		numberListField.setAccessible(true);
		Referee referee = (Referee)reCon.newInstance(10);
		numberListField.set(referee, Arrays.asList(1,2,3));
		Player[] players = {referee};
		
		Class<GameService> gameClazz = GameService.class;
		Constructor<?> con = gameClazz.getConstructor(new Class[]{});
		Field playersField = gameClazz.getDeclaredField("players");
		playersField.setAccessible(true);
		GameService service = (GameService) con.newInstance();
		playersField.set(service, players);
		
		assertEquals("1 2 3 ", service.getAnswer(0));
	}
	
	@Test
	public void inputNumTest() throws Exception {
		Class<Referee> refClazz = Referee.class;
		Constructor<?>[] cons = refClazz.getConstructors();
		Constructor<?> reCon = cons[0];
		Field numberListField = refClazz.getDeclaredField("numberList");
		numberListField.setAccessible(true);
		Referee referee = (Referee)reCon.newInstance(10);
		numberListField.set(referee, Arrays.asList(1,2,3));
		Player[] players = {referee};
		
		Class<GameService> gameClazz = GameService.class;
		Constructor<?> con = gameClazz.getConstructor(new Class[]{});
		Field playersField = gameClazz.getDeclaredField("players");
		Field numberSizeField = gameClazz.getDeclaredField("numberSize");
		playersField.setAccessible(true);
		numberSizeField.setAccessible(true);
		GameService service = (GameService) con.newInstance();
		playersField.set(service, players);
		numberSizeField.set(service, 3);
		
		assertEquals("2S 0B", service.inputNum(0, "1 2 4"));
		assertEquals("1S 0B", service.inputNum(0, "1 5 4"));
		assertEquals("0S 0B", service.inputNum(0, "5 7 4"));
		assertEquals("1S 1B", service.inputNum(0, "1 3 0"));
		assertEquals("1S 2B", service.inputNum(0, "1 3 2"));
		assertEquals("0S 3B", service.inputNum(0, "3 1 2"));
		assertEquals("0S 2B", service.inputNum(0, "5 1 2"));
		assertEquals("0S 3B", service.inputNum(0, "2 3 1"));
		assertEquals("성공!!!", service.inputNum(0, "1 2 3"));
	}
}
