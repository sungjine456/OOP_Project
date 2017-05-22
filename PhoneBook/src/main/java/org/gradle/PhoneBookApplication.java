package org.gradle;

import java.util.Scanner;

import org.gradle.common.Utils;
import org.gradle.domain.User;
import org.gradle.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhoneBookApplication {
	private static final Logger log = LoggerFactory.getLogger(PhoneBookApplication.class);
	private static final Scanner sc = new Scanner(System.in);
	
	private static UserRepository userRepository = UserRepository.getInstance();
	
	public static void main(String[] args){
		log.info("Application Start");
		boolean playGame = true;
		while(playGame){
			System.out.println("1. 로그인 \n2. 회원가입\n3. 종료");
			int n = Utils.changeStringIsNumber(sc.next());
			switch (n) {
				case 1:
					break;
				case 2:
					if(joinUser()){
						// TODO : 로그인
					}
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
	
	private static boolean joinUser(){
		System.out.print("아이디를 입력해주세요 : ");
		String id = sc.next();
		System.out.print("비밀번호를 입력해주세요 : ");
		String password = sc.next();
		System.out.print("이름을 입력해주세요 : ");
		String name = sc.next();
		System.out.print("전화번호를 입력해주세요(ex:000-0000-0000) : ");
		String number = sc.next();
		if(Utils.numberCheck(number)){
			return false;
		}
		userRepository.save(new User(id, password, name, number));
		return true;
	}
}
