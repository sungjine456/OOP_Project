package org.gradle;

import java.util.List;
import java.util.Scanner;

import org.gradle.common.StringUtils;
import org.gradle.common.Utils;
import org.gradle.domain.Group;
import org.gradle.domain.PhoneBook;
import org.gradle.domain.User;
import org.gradle.exception.FailNumberException;
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
					String[] strArr = inputNameAndNumber();
					userRepository.save(new User(joinId, joinPassword, strArr[0], strArr[1]));
					
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
			PhoneBook phoneBook = user.getPhoneBook();
			System.out.println(user.getName() + "님의 전화번호 부입니다.( " + phoneBook.getGroupKeys().size() + " 개의 그룹이 있습니다.)"
					+ "\n1. 모든 연락처 보기\n2. 그룹별 연락처 보기\n3. 그룹 검색\n4. 그룹 추가\n5. 연락처 검색\n6. 연락처 추가\n7. 연락처 삭제\n8. 모든 그룹명 보기\n9. 나가기");
			int n = Utils.changeStringIsNumber(sc.next());
			switch(n){
				case 1:
					printList(phoneBook.allContcatList());
					break;
				case 2:
					System.out.print("그룹 명을 입력해주세요. : ");
					group(phoneBook.getGroup(sc.next()));
					break;
				case 3:
					break;
				case 4:
					System.out.print("추가할 그룹명을 입력해주세요. : ");
					phoneBook.addGroup(sc.next());
					break;
				case 5:
					System.out.print("검색할 연락처를 입력해주세요. : ");
					printList(phoneBook.searchContCat(sc.next()));
					break;
				case 6:
					System.out.print("추가할 연락처의 그룹을 입력해주세요.(없으면 Enter를 치세요.) : ");
					String groupName = sc.next();
					String[] strArr = inputNameAndNumber();
					phoneBook.addContcat(groupName, strArr[0], strArr[1]);
					break;
				case 7:
					System.out.print("삭제할 연락처의 그룹을 입력해주세요.(없으면 Enter를 치세요.) : ");
					groupName = sc.next();
					strArr = inputNameAndNumber();
					phoneBook.deleteContcat(groupName, strArr[0], strArr[1]);
					break;
				case 8:
					printList(phoneBook.getGroupKeys());
					break;
				case 9:
					isPhoneBook = false;
					break;
				default :
					System.out.println("다시 입력해 주세요.");
					break;
			}
		}
	}
	
	private static void group(Group group){
		boolean isGroup = true;
		while(isGroup){
			System.out.println(group.getGroupName() + "그룹 입니다.( " + group.contcatSize() + " 개의 연락처가 있습니다.)"
					+ "\n1. 연락처 보기\n2. 연락처 추가\n3. 연락처 검색\n4. 연락처 삭제\n5. 나가기");
			int n = Utils.changeStringIsNumber(sc.next());
			switch(n){
				case 1:
					printList(group.getContcats());
					break;
				case 2:
					addContcat(group);
					break;
				case 3:
					System.out.print("검색할 내용을 입력해주세요 : ");
					String word = sc.next();
					printList(group.searchContcat(word));
					break;
				case 4:
					deleteContcat(group);
					break;
				case 5:
					isGroup = false;
					break;
				default :
					System.out.println("다시 입력해 주세요.");
					break;
			}
		}
	}
	
	private static <T> void printList(List<T> list){
		if(list.size() == 0){
			System.out.println("등록된 내용이 없습니다.");
		}
		list.stream().forEach(System.out::println);
	}
	
	private static boolean idAndPasswordCheck(String id, String password){
		User user = userRepository.find(id);
		
		if(user != null && StringUtils.equals(user.getPassword(), password)){
			return true;
		}
		return false;
	}
	
	private static void addContcat(Group group){
		System.out.print("추가할 연락처를 입력해주세요.\n이름 : ");
		String[] strArr = inputNameAndNumber();
		group.addContcat(strArr[0], strArr[1]);
	}

	private static void deleteContcat(Group group){
		System.out.print("삭제할 연락처를 입력해주세요.\n이름 : ");
		String[] strArr = inputNameAndNumber();
		group.deleteContcat(strArr[0], strArr[1]);
	}
	
	private static String[] inputNameAndNumber(){
		String name = sc.next();
		System.out.print("전화번호 : ");
		String number = sc.next();
		if(!Utils.numberCheck(number)){
			System.out.println("잘못된 형식의 번호입니다.");
			throw new FailNumberException();
		}
		String[] strArr = {name, number};
		return strArr;
	}
}
