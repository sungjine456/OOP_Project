package org.gradle;

import java.util.Scanner;

import org.gradle.common.StringUtils;
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
		boolean startApp = true;
		while(startApp){
			System.out.println("1. 로그인 \n2. 회원가입\n3. 종료");
			int n = Utils.changeStringIsNumber(sc.next());
			switch (n) {
				case 1:
					System.out.print("아이디를 입력해주세요.");
					String id = sc.next();
					System.out.print("비밀번호를 입력해주세요.");
					String password = sc.next();
					if(idAndPasswordCheck(id, password)){
						// TODO: 로그인
					}
					System.out.println("잘못된 아이디와 비밀번호 입니다.");
					break;
				case 2:
					System.out.print("아이디를 입력해주세요 : ");
					String joinId = sc.next();
					System.out.print("비밀번호를 입력해주세요 : ");
					String joinPassword = sc.next();
					System.out.print("이름을 입력해주세요 : ");
					String name = sc.next();
					System.out.print("전화번호를 입력해주세요(ex:000-0000-0000) : ");
					String number = sc.next();
					System.out.println(number);
					if(!Utils.numberCheck(number)){
						System.out.println("잘못된 형식의 번호입니다.");
						break;
					}
					userRepository.save(new User(joinId, joinPassword, name, number));
					// TODO: 로그인
					break;
				case 3:
					startApp = false;
					break;
				default:
					System.out.println("다시 입력해 주세요.");
					break;
			}
		}
	}
	
	private static boolean idAndPasswordCheck(String id, String password){
		User user = userRepository.find(id);
		
		if(user != null && StringUtils.equals(user.getPassword(), password)){
			return true;
		}
		return false;
	}
}
