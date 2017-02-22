package org.gradle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.gradle.domain.Player;
import org.gradle.domain.Referee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {
	private static final Logger log = LoggerFactory.getLogger(GameController.class);
	@RequestMapping("/oneStart.do")
	public String oneStart(int num, HttpSession session, HttpServletRequest req){
		log.debug("oneStart.do");
		log.debug(num+"");
		Player player = new Referee(num);
		session.setAttribute("player", player);
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
	public String finish(){
		log.debug("finish.do");
		return "index";
	}
	@RequestMapping("/chooseNumber.do")
	public String chooseNumber(String nextUrl, HttpServletRequest req){
		log.debug("chooseNumber.do");
		req.setAttribute("nextUrl", nextUrl);
		return "view/chooseNumber";
	}
}
