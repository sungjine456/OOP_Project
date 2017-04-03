package org.gradle.dao;

import static org.junit.Assert.assertEquals;

import org.gradle.mybatis.MyBatisConnectionFactory;
import org.junit.Test;

public class PlayerDaoTest {

	@Test
	public void test() {
		PlayerDao dao = new PlayerDao(MyBatisConnectionFactory.getSqlSessionFactory());
		assertEquals(1, dao.selectAll().size());
	}
}
