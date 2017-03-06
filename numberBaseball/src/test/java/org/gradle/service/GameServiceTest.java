package org.gradle.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.gradle.domain.Player;
import org.junit.Test;

public class GameServiceTest {
	
	@Test
	public void makePersonGameTest() throws Exception {
		Class<GameService> clazz = GameService.class;
		Constructor<?> con = clazz.getConstructor(new Class[]{});
		Field field = clazz.getDeclaredField("players");
		field.setAccessible(true);
		GameService service = (GameService) con.newInstance();
		
		assertNull(field.get(service));
		
		service.makePersonGame(3);
		Player[] players = (Player[])field.get(service);
		
		assertEquals(1, players.length);
	}

	@Test
	public void makePeopleGameTest() throws Exception {
		Class<GameService> clazz = GameService.class;
		Constructor<?> con = clazz.getConstructor(new Class[]{});
		Field field = clazz.getDeclaredField("players");
		field.setAccessible(true);
		GameService service = (GameService) con.newInstance();
		
		assertNull(field.get(service));
		
		service.makePeopleGame(3, 2);
		Player[] players = (Player[])field.get(service);
		
		assertEquals(2, players.length);
	}
}
