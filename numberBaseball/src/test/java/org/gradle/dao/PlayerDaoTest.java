package org.gradle.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.gradle.dto.PlayerDto;
import org.gradle.vo.PlayerVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/jdbc-config.xml"})
public class PlayerDaoTest {
	
	@Autowired
	private PlayerDao playerDao;

	@Test
	@Transactional
	public void selectAllTest() {
		assertEquals(1, playerDao.selectAll().size());
	}
	
	@Test
	@Transactional
	public void loginCheck(){
		PlayerDto dto = new PlayerDto("test", "1234");
		assertTrue(playerDao.loginCheck(dto));
	}
	
	@Test
	@Transactional
	public void findPlayer(){
		assertEquals("test", playerDao.findPlayer("test").getId());
	}
	
	@Test
	@Transactional
	public void insertPlayer(){
		playerDao.insertPlayer(new PlayerDto("testId", "testPassword"));
		List<PlayerVo> players = playerDao.selectAll();
		assertEquals(2, players.size());
		PlayerVo player = players.get(1);
		assertEquals("testId", player.getId());
	}
}
