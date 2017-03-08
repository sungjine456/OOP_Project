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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GameController {
	private static final Logger log = LoggerFactory.getLogger(GameController.class);
	
	private final int PLAYER_SIZE_IS_TWO = 2;
	
	@Autowired
	private GameService gameService;
	
	@RequestMapping("/oneStart.do")
	public String oneStart(int num, String nextUrl, HttpServletRequest req){
		log.debug("oneStart.do");
		log.debug("nextUrl" + nextUrl);
		log.debug("num : " + num);
		
		gameService.makePersonGame(num);
		
		req.setAttribute("nextUrl", nextUrl);
		req.setAttribute("num", num);
		return "view/main";
	}
	@RequestMapping("/twoStart.do")
	public String twoStart(int num, String nextUrl, HttpServletRequest req){
		log.debug("twoStart.do");
		log.debug("nextUrl" + nextUrl);
		log.debug("num : " + num);
		
		gameService.makePeopleGame(num, PLAYER_SIZE_IS_TWO);
		
		req.setAttribute("playerSize", PLAYER_SIZE_IS_TWO);
		req.setAttribute("nextUrl", nextUrl);
		req.setAttribute("num", num);
		return "view/main";
	}
	@RequestMapping("/manyStart.do")
	public String manyStart(int num, int playerSize, String nextUrl, HttpServletRequest req){
		log.debug("manyStart.do");
		log.debug("nextUrl" + nextUrl);
		log.debug("num : " + num);
		log.debug("playerSize : " + playerSize);
		
		gameService.makePeopleGame(num, playerSize);
		
		req.setAttribute("playerSize", playerSize);
		req.setAttribute("nextUrl", nextUrl);
		req.setAttribute("num", num);
		return "view/main";
	}
	@RequestMapping("/finish.do")
	public String finish(String nextUrl, Integer num, HttpServletRequest req){
		log.debug("finish.do");
		log.debug("nextUrl" + nextUrl);
		log.debug("num : " + num);
		
		req.setAttribute("nextUrl", nextUrl);
		req.setAttribute("num", num);
		return "view/finish";
	}
	@RequestMapping("/chooseNumber.do")
	public String chooseNumber(String nextUrl, @RequestParam(defaultValue="1") int playerSize, 
			HttpServletRequest req){
		log.debug("chooseNumber.do");
		log.debug("nextUrl : " + nextUrl);
		log.debug("playerSize : " + playerSize);
		req.setAttribute("nextUrl", nextUrl);
		req.setAttribute("playerSize", playerSize);
		return "view/chooseNumber";
	}
	@RequestMapping("choosePlayerSize.do")
	public String choosePlayerSize(String nextUrl, HttpServletRequest req){
		log.debug("choosePlayerSize.do");
		log.debug("nextUrl : " + nextUrl);
		req.setAttribute("nextUrl", nextUrl);
		return "view/choosePlayerSize";
	}
	@RequestMapping(value="/inputNum.do", produces="application/json;charset=UTF-8")
	public @ResponseBody Map<String, String> inputNum(int playerNumber, String input){
		log.debug("inputNum.do");
		log.debug("input : " + input);
		log.debug("playerNumber : " + playerNumber);
		Map<String, String> map = new HashMap<>();
		map.put("confirm", gameService.inputNum(playerNumber, input));
		return map;
	}
	@RequestMapping("/giveUp.do")
	public @ResponseBody Map<String, String> giveUp(int playerNumber){
		log.debug("giveUp.do");
		Map<String, String> map = new HashMap<>();
		map.put("answer", gameService.getAnswer(playerNumber));
		return map;
	}
}
