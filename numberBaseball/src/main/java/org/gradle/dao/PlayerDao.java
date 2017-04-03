package org.gradle.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.gradle.domain.Player;

public class PlayerDao {
	private SqlSessionFactory sqlSessionFactory = null;
	
	public PlayerDao(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public  List<Player> selectAll(){
        List<Player> list = null;
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            list = session.selectList("Player.selectAll");
        } finally {
            session.close();
        }
        System.out.println("selectAll() --> "+list);
        return list;
    }
}
