package org.gradle.dao;

import static org.junit.Assert.*;

import org.gradle.dto.PlayerDto;
import org.gradle.mybatis.MyBatisConnectionFactory;
import org.junit.Test;

public class PlayerDaoTest {

	@Test
	public void selectAllTest() {
		PlayerDao dao = new PlayerDao(MyBatisConnectionFactory.getSqlSessionFactory());
		assertEquals(1, dao.selectAll().size());
	}
	
	@Test
	public void loginCheck(){
		PlayerDao dao = new PlayerDao(MyBatisConnectionFactory.getSqlSessionFactory());
		PlayerDto dto = new PlayerDto();
		dto.setId("test");
		dto.setPassword("1234");
		assertTrue(dao.loginCheck(dto));
	}
	
	@Test
	public void findPlayer(){
		PlayerDao dao = new PlayerDao(MyBatisConnectionFactory.getSqlSessionFactory());
		assertEquals("test", dao.findPlayer("test").getId());
	}
}
