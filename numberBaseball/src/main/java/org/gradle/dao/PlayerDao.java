package org.gradle.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.gradle.domain.Player;
import org.gradle.dto.PlayerDto;
import org.gradle.vo.PlayerVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("playerDao")
public class PlayerDao {
	private static final Logger log = LoggerFactory.getLogger(PlayerDao.class);
	
	@Autowired
	private SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
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
