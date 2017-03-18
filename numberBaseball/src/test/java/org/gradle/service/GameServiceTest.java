package org.gradle.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

import org.gradle.domain.Player;
import org.junit.Before;
import org.junit.Test;

public class GameServiceTest {
	private Class<GameService> serviceClazz;
	private Constructor<?> serviceCon;
	private GameService service;
	private Class<Player> playerClazz;
	private Constructor<?> playerCon;
	private Player player;
	
	@Before
	public void setup() throws Exception {
		serviceClazz = GameService.class;
		serviceCon = serviceClazz.getConstructor(new Class[]{});
		service = (GameService) serviceCon.newInstance();
		playerClazz = Player.class;
		playerCon = playerClazz.getConstructor();
		player = (Player)playerCon.newInstance();
	}
	
	@Test
	public void makeGameTestPramOneInt() throws Exception {
		Field field = serviceClazz.getDeclaredField("players");
		field.setAccessible(true);
		
		assertNull(field.get(service));
		
		service.makeGame(3);
		Player[] players = (Player[])field.get(service);
		
		assertEquals(1, players.length);
	}

	@Test
	public void makeGameTestPramsTwoInt() throws Exception {
		Field field = serviceClazz.getDeclaredField("players");
		field.setAccessible(true);
		
		assertNull(field.get(service));
		
		service.makeGame(3, 2);
		Player[] players = (Player[])field.get(service);
		
		assertEquals(2, players.length);
	}
	
	@Test
	public void getAnswerTest() throws Exception {
		Field numberListField = playerClazz.getDeclaredField("numberList");
		numberListField.setAccessible(true);
		numberListField.set(player, Arrays.asList(1,2,3));
		Player[] players = {player};
		
		Field playersField = serviceClazz.getDeclaredField("players");
		playersField.setAccessible(true);
		playersField.set(service, players);
		
		assertEquals("1 2 3 ", service.getAnswer(0));
	}
	
	@Test
	public void inputNumTest() throws Exception {
		Field numberListField = playerClazz.getDeclaredField("numberList");
		numberListField.setAccessible(true);
		numberListField.set(player, Arrays.asList(1,2,3));
		Player[] players = {player};
		
		Field playersField = serviceClazz.getDeclaredField("players");
		Field numberSizeField = serviceClazz.getDeclaredField("numberSize");
		playersField.setAccessible(true);
		numberSizeField.setAccessible(true);
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
