package org.gradle;

import org.gradle.common.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhoneBookApplication {
	private static final Logger log = LoggerFactory.getLogger(PhoneBookApplication.class);
	
	public static void main(String[] args){
		log.info("Application Start");
		boolean playGame = true;
		while(playGame){
			System.out.println("1. 로그인 \n2. 회원가입\n3. 종료");
			int n = Utils.changeStringIsNumber(Utils.getScanner().next());
			switch (n) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					playGame = false;
					break;
				default:
					System.out.println("다시 입력해 주세요.");
					break;
			}
		}
	}
}
