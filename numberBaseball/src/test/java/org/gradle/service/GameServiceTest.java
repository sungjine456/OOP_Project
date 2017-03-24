package org.gradle.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

import org.gradle.common.VerdictEnum;
import org.gradle.domain.Member;
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
		assertEquals(VerdictEnum.SUCCESS.getValue(), service.inputNum(0, "1 2 3"));
	}
	
	@Test
	public void nextPlayerTest() throws Exception {
		Field numberSizeField = serviceClazz.getDeclaredField("numberSize");
		numberSizeField.setAccessible(true);
		numberSizeField.set(service, 2);
		
		Class<Player> playerClazz1 = Player.class;
		Constructor<?> playerCon1 = playerClazz1.getConstructor();
		Player player1 = (Player)playerCon1.newInstance();
		
		Field giveUpField = playerClazz.getDeclaredField("giveUp");
		giveUpField.setAccessible(true);
		Field giveUpField1 = playerClazz.getDeclaredField("giveUp");
		giveUpField1.setAccessible(true);
		
		giveUpField.set(player, false);
		giveUpField1.set(player1, false);
		Player[] players = {player, player1};
		
		Field playersField = serviceClazz.getDeclaredField("players");
		playersField.setAccessible(true);
		playersField.set(service, players);
		
		assertEquals(1, service.nextPlayer(2));
		
		numberSizeField.set(service, 4);
		
		Class<Player> playerClazz2 = Player.class;
		Constructor<?> playerCon2 = playerClazz2.getConstructor();
		Player player2 = (Player)playerCon2.newInstance();
		Class<Player> playerClazz3 = Player.class;
		Constructor<?> playerCon3 = playerClazz3.getConstructor();
		Player player3 = (Player)playerCon3.newInstance();
		
		Field giveUpField2 = playerClazz.getDeclaredField("giveUp");
		giveUpField2.setAccessible(true);
		Field giveUpField3 = playerClazz.getDeclaredField("giveUp");
		giveUpField3.setAccessible(true);
		
		giveUpField.set(player, true);
		giveUpField1.set(player1, false);
		giveUpField2.set(player2, true);
		giveUpField3.set(player3, false);
		
		Player[] players2 = {player, player1, player2, player3};
		
		playersField = serviceClazz.getDeclaredField("players");
		playersField.setAccessible(true);
		playersField.set(service, players2);
		
		assertEquals(4, service.nextPlayer(2));
	}
	
	@Test
	public void gameOverTest() throws Exception {
		Class<Player> playerClazz1 = Player.class;
		Constructor<?> playerCon1 = playerClazz1.getConstructor();
		Player player1 = (Player)playerCon1.newInstance();
		
		Field giveUpField = playerClazz.getDeclaredField("giveUp");
		giveUpField.setAccessible(true);
		
		Field giveUpField1 = playerClazz.getDeclaredField("giveUp");
		giveUpField1.setAccessible(true);
		
		giveUpField.set(player, false);
		giveUpField1.set(player1, false);
		Player[] players = {player, player1};
		
		Field playersField = serviceClazz.getDeclaredField("players");
		playersField.setAccessible(true);
		playersField.set(service, players);
		
		assertFalse(service.gameOver());
		
		giveUpField.set(player, true);
		giveUpField1.set(player1, false);
		Player[] players1 = {player, player1};
		
		playersField = serviceClazz.getDeclaredField("players");
		playersField.setAccessible(true);
		playersField.set(service, players1);
		
		assertTrue(service.gameOver());
	}
	
	@Test
	public void setNumber() throws Exception {
		Class<Member> memberClazz = Member.class;
		Constructor<?> memberCon = memberClazz.getConstructor(new Class[]{Integer.TYPE});
		
		Field field = serviceClazz.getDeclaredField("players");
		field.setAccessible(true);
		Member[] members = {(Member) memberCon.newInstance(3)};
		field.set(service, members);
		
		assertFalse(service.setMakeNumber(0, "125"));
		assertTrue(service.setMakeNumber(1, "125"));
		assertFalse(service.setMakeNumber(2, "125"));
	}
}
