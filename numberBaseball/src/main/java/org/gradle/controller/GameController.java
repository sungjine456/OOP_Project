package org.gradle.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping("/oneStart.do")
	public String oneStart(int num, String nextUrl, HttpSession session, HttpServletRequest req){
		log.debug("oneStart.do");
		log.debug(nextUrl);
		log.debug(num+"");
		gameService.makeGame(num);
		
		req.setAttribute("nextUrl", nextUrl);
		req.setAttribute("num", num);
		return "view/main";
	}
	@RequestMapping("/twoStart.do")
	public String twoStart(){
		log.debug("twoStart.do");
		return "view/main";
	}
	@RequestMapping("/manyStart.do")
	public String manyStart(){
		log.debug("manyStart.do");
		return "view/main";
	}
	@RequestMapping("/finish.do")
	public String finish(String nextUrl, Integer num, HttpServletRequest req){
		log.debug("finish.do");
		log.debug(nextUrl);
		log.debug(num + "");
		
		req.setAttribute("nextUrl", nextUrl);
		req.setAttribute("num", num);
		return "view/finish";
	}
	@RequestMapping("/chooseNumber.do")
	public String chooseNumber(String nextUrl, HttpServletRequest req){
		log.debug("chooseNumber.do");
		req.setAttribute("nextUrl", nextUrl);
		return "view/chooseNumber";
	}
	@RequestMapping(value="/inputNum.do", produces="application/json;charset=UTF-8")
	public @ResponseBody Map<String, String> inputNum(String input){
		log.debug("inputNum.do");
		log.debug("input : " + input);
		Map<String, String> map = new HashMap<>();
		map.put("confirm", gameService.inputNum(input));
		return map;
	}
	@RequestMapping("/giveUp.do")
	public @ResponseBody Map<String, String> giveUp(){
		log.debug("giveUp.do");
		Map<String, String> map = new HashMap<>();
		map.put("answer", gameService.getAnswer());
		return map;
	}
}
