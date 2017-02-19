package org.gradle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {
	@RequestMapping("/oneStart.do")
	public String oneStart(){
		System.out.println("oneStart.do");
		return "index";
	}
	@RequestMapping("/twoStart.do")
	public String twoStart(){
		System.out.println("twoStart.do");
		return "index";
	}
	@RequestMapping("/manyStart.do")
	public String manyStart(){
		System.out.println("manyStart.do");
		return "index";
	}
	@RequestMapping("/finish.do")
	public String finish(){
		System.out.println("finish.do");
		return "index";
	}
}
