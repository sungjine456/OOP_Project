package org.gradle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("/test.do")
	public String test(){
		return "test.html";
	}
	
	@RequestMapping("/jspTest.do")
	public String jspTest(){
		return "test";
	}
}
