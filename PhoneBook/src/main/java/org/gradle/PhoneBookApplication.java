package org.gradle;

import java.util.List;
import java.util.Scanner;

import org.gradle.common.StringUtils;
import org.gradle.common.Utils;
import org.gradle.domain.Contcat;
import org.gradle.domain.Group;
import org.gradle.domain.PhoneBook;
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
						login(userRepository.find(id));
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
					
					login(userRepository.find(joinId));
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
	
	private static void login(User user){
		boolean isLogin = true;
		while(isLogin){
			System.out.println("로그인중...\n1. 전화번호 부\n2. 친구\n3. 로그아웃");
			int n = Utils.changeStringIsNumber(sc.next());
			switch (n) {
				case 1:
					phoneBook(user);
					break;
				case 2:
					break;
				case 3:
					isLogin = false;
					break;
				default :
					System.out.println("다시 입력해 주세요.");
					break;
			}
		}
	}
	
	private static void phoneBook(User user){
		boolean isPhoneBook = true;
		while(isPhoneBook){
			System.out.println(user.getName() + "님의 전화번호 부입니다.\n1. 모든 연락처 보기\n2. 그룹별 연락처 보기\n3. 그룹 검색");
			int n = Utils.changeStringIsNumber(sc.next());
			PhoneBook phoneBook = user.getPhoneBook();
			switch(n){
				case 1:
					List<Contcat> contcatList = phoneBook.allContcatList();
					for(Contcat contcat: contcatList){
						System.out.println(contcat);
					}
					break;
				case 2:
					System.out.print("그룹 명을 입력해주세요.");
					String groupName = sc.next();
					group(phoneBook.getGroup(groupName), groupName);
					break;
				case 3:
					break;
				default :
					System.out.println("다시 입력해 주세요.");
					break;
			}
		}
	}
	
	private static void group(Group group, String groupName){
		boolean isGroup = true;
		while(isGroup){
			System.out.println(groupName + "그룹 입니다.\n1. 연락처 보기\n2. 연락처 추가\n3. 연락처 검색\n4. 나가기");
			int n = Utils.changeStringIsNumber(sc.next());
			switch(n){
				case 1:
					printContcat(group.getContcats());
					break;
				case 2:
					System.out.print("추가할 연락처를 입력해주세요.\n이름 : ");
					String name = sc.next();
					System.out.print("전화번호 : ");
					String number = sc.next();
					group.addContcat(name, number);
					break;
				case 3:
					System.out.print("검색할 내용을 입력해주세요 : ");
					String word = sc.next();
					printContcat(group.searchContcat(word));
					break;
				case 4:
					isGroup = false;
					break;
				default :
					System.out.println("다시 입력해 주세요.");
					break;
			}
		}
	}
	
	private static void printContcat(List<Contcat> contcatList){
		if(contcatList.size() == 0){
			System.out.println("등록된 연락처가 없습니다.");
		}
		for(Contcat contcat : contcatList){
			System.out.println(contcat);
		}
	}
	
	private static void contcat(User user){
		boolean isContcat = true;
		while(isContcat){
			System.out.println(user.getName() + "님의 연락처입니다.\n1. 연락처 보기\n2. 연락처 추가\n3. 연락처 삭제\n4. 나가기");
			int n = Utils.changeStringIsNumber(sc.next());
			switch(n){
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					isContcat = false;
					break;
				default :
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
