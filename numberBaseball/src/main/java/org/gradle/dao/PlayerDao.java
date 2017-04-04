package org.gradle.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.gradle.domain.Player;
import org.gradle.dto.PlayerDto;
import org.gradle.vo.PlayerVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerDao {
	private static final Logger log = LoggerFactory.getLogger(PlayerDao.class);
	private SqlSession session = null;
	
	public PlayerDao(SqlSessionFactory sqlSessionFactory){
		session = sqlSessionFactory.openSession();
	}
	
	public List<Player> selectAll(){
        List<Player> list = null;
 
        try {
            list = session.selectList("Player.selectAll");
        } catch (Exception e) {
        	log.debug(e.getMessage());
		}
        return list;
    }
	
	public boolean loginCheck(PlayerDto dto){
		PlayerVo player = null;
		try{
			player = session.selectOne("Player.loginCheck", dto);
		} catch (Exception e) {
        	log.debug(e.getMessage());
		}
		if(player==null){
			return false;
		}
		return true;
	}
	
	public PlayerVo findPlayer(String id){
		PlayerVo player = null;
		try{
			player = session.selectOne("Player.findPlayer", id);
		} catch (Exception e) {
        	log.debug(e.getMessage());
		}
		return player;
	}
}
