package org.gradle.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {
	private static final Logger log = LoggerFactory.getLogger(GameController.class);
	@RequestMapping("/oneStart.do")
	public String oneStart(){
		log.debug("oneStart.do");
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
}
