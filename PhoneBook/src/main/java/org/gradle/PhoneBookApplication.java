package org.gradle;

import java.util.Scanner;

import org.gradle.controller.MainController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhoneBookApplication {
	private static final Logger log = LoggerFactory.getLogger(PhoneBookApplication.class);
	
	public static void main(String[] args){
		log.info("Application Start");
		MainController mainController = new MainController(new Scanner(System.in));
		mainController.play();
	}
}
