package org.gradle.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.gradle.dto.PlayerDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/jdbc-config.xml"})
public class PlayerDaoTest {
	
	@Resource(name="playerDao")
	private PlayerDao playerDao;

	@Test
	public void selectAllTest() {
		assertEquals(1, playerDao.selectAll().size());
	}
	
	@Test
	public void loginCheck(){
		PlayerDto dto = new PlayerDto();
		dto.setId("test");
		dto.setPassword("1234");
		assertTrue(playerDao.loginCheck(dto));
	}
	
	@Test
	public void findPlayer(){
		assertEquals("test", playerDao.findPlayer("test").getId());
	}
}
