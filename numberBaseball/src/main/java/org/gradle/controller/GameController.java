package org.gradle.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.gradle.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GameController {
	private static final Logger log = LoggerFactory.getLogger(GameController.class);
	
	@Autowired
	private GameService gameService;
	
	@RequestMapping("/start.do")
	public String start(int num, int playerSize, HttpServletRequest req){
		log.debug("start.do");
		log.debug("num : " + num);
		log.debug("playerSize : " + playerSize);
		
		gameService.makeGame(num, playerSize);
		
		req.setAttribute("isNotMadeNum", true);
		req.setAttribute("playerSize", playerSize);
		req.setAttribute("num", num);
		return "view/main";
	}
	@RequestMapping("/finish.do")
	public String finish(int num, int playerSize, boolean isNotMadeNum, HttpServletRequest req){
		log.debug("finish.do");
		log.debug("num : " + num);
		log.debug("playerSize : " + playerSize);
		log.debug("isNotMadeNum : " + isNotMadeNum);
		
		req.setAttribute("isNotMadeNum", isNotMadeNum);
		req.setAttribute("num", num);
		req.setAttribute("playerSize", playerSize);
		return "view/finish";
	}
	@RequestMapping("/chooseNumber.do")
	public String chooseNumber(int playerSize, 
			HttpServletRequest req){
		log.debug("chooseNumber.do");
		log.debug("playerSize : " + playerSize);
		req.setAttribute("playerSize", playerSize);
		return "view/chooseNumber";
	}
	@RequestMapping("choosePlayerSize.do")
	public String choosePlayerSize(){
		log.debug("choosePlayerSize.do");
		return "view/choosePlayerSize";
	}
	@RequestMapping(value="/inputNum.do", produces="application/json;charset=UTF-8")
	public @ResponseBody Map<String, String> inputNum(int playerNumber, String input){
		log.debug("inputNum.do");
		log.debug("input : " + input);
		log.debug("playerNumber : " + playerNumber);
		
		Map<String, String> map = new HashMap<>();
		System.out.println(gameService.nextPlayer(playerNumber));
		if(!gameService.IsGiveUpPlayer(playerNumber)){
			map.put("confirm", gameService.inputNum(playerNumber, input));
		} 
		map.put("nextPlayer", String.valueOf(gameService.nextPlayer(playerNumber)));
		map.put("isGiveUpPlayer", String.valueOf(gameService.IsGiveUpPlayer(playerNumber)));
		return map;
	}
	@RequestMapping("/giveUp.do")
	public @ResponseBody Map<String, String> giveUp(int playerNumber){
		log.debug("giveUp.do");
		log.debug("playerNumber : " + playerNumber);
		
		gameService.setGiveUp(playerNumber);
		
		Map<String, String> map = new HashMap<>();
		map.put("answer", gameService.getAnswer(playerNumber));
		map.put("gameOver", String.valueOf(gameService.gameOver()));
		return map;
	}
	@RequestMapping("/makeNumber.do")
	public String makeNumber(int num, int playerSize, int playerNumber, 
			String makeNumber, HttpServletRequest req){
		log.debug("makeNumberPage.do");
		log.debug("num : " + num);
		log.debug("playerSize : " + playerSize);
		log.debug("playerNumber : " + playerNumber);
		log.debug("makeNumber : " + makeNumber);

		boolean isReSet = false;
		
		req.setAttribute("num", num);
		req.setAttribute("playerSize", playerSize);
		if(playerSize > playerNumber){
			if(playerNumber == 0){
				gameService.makeGameAndMakeNumber(num, playerSize);
			} else {
				isReSet = !gameService.setMakeNumber(playerNumber, makeNumber);
			}
			if(playerNumber != 0 && isReSet){
				req.setAttribute("message", "다시 입력해주세요.");
				req.setAttribute("playerNumber", playerNumber-1);
			} else {
				req.setAttribute("playerNumber", playerNumber);
			}
			return "view/makeNumber";
		} else {
			isReSet = !gameService.setMakeNumber(playerNumber, makeNumber);
			if(playerNumber != 0 && isReSet){
				req.setAttribute("message", "다시 입력해주세요.");
				req.setAttribute("playerNumber", playerNumber-1);
				
				return "view/makeNumber";
			}
			req.setAttribute("isNotMadeNum", false);
			return "view/main";
		}
	}
}
