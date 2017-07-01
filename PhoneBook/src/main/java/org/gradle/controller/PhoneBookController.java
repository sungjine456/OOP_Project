package org.gradle.controller;

import java.util.List;
import java.util.Scanner;

import org.gradle.domain.PhoneBook;
import org.gradle.domain.User;
import org.gradle.exception.AlreadyGroupNameException;

public class PhoneBookController extends Controller {
	private GroupController groupController = new GroupController(sc);
	
	private User user;
	private PhoneBook phoneBook;
	private final String message = "1. 모든 연락처 보기\n2. 그룹별 연락처 보기\n3. 그룹 검색\n4. 그룹 추가\n5. 그룹명 수정\n6. 연락처 검색\n7. 모든 그룹명 보기\n8. 나가기";
	
	public PhoneBookController(Scanner sc) {
		super(sc);
	}
	
	public void play(User user){
		this.user = user;
		super.play(message, 8);
	}

	@Override
	public void searchMenu(int num) {
		phoneBook = user.getPhoneBook();
		if(num == 1){
			printList(phoneBook.allContcatList());
		} else if(num == 2){
			concatListByGroupName();
		} else if(num == 3){
			searchGroupByGroupNmae();
		} else if(num == 4){
			addGroup();
		} else if(num == 5){
			updateGroup();
		} else if(num == 6){
			searchContcat();
		} else if(num == 7){
			printList(phoneBook.getGroupKeys());
		}
	}
	// view method
	private void searchContcat(){
		System.out.print("검색할 연락처를 입력해주세요. : ");
		printList(phoneBook.searchContCat(sc.next()));
	}
	private void updateGroup(){
		System.out.print("수정할 대상의 그룹명을 입력해주세요. : ");
		String groupName = sc.next();
		if(!phoneBook.isCangedGroupName(groupName)){
			System.out.println("존재하지 않거나 수정할 수 없는 그룹입니다.");
		} else {
			System.out.println("수정할 그룹명을 입력해주세요. : ");
			String changeGroupName = sc.next();
			try{
				phoneBook.groupKeyChange(groupName, changeGroupName);
			} catch(AlreadyGroupNameException agne){
				phoneBook.groupKeyChange(groupName, reInputGroupName(phoneBook, phoneBook.hasGroupName(changeGroupName)));
			}
		}
	}
	private void addGroup(){
		System.out.print("추가할 그룹명을 입력해주세요. : ");
		String groupName = sc.next();
		try{
			phoneBook.addGroup(groupName);
		} catch(AlreadyGroupNameException agne){
			phoneBook.addGroup(reInputGroupName(phoneBook, phoneBook.hasGroupName(groupName)));
		}
	}
	private void searchGroupByGroupNmae(){
		System.out.print("그룹 명을 입력해주세요. : ");
		printList(phoneBook.searchGroup(sc.next()));
	}
	private void concatListByGroupName(){
		System.out.print("그룹 명을 입력해주세요. : ");
		String groupName = sc.next();
		if(phoneBook.hasGroupName(groupName)){
			groupController.play(phoneBook.getGroup(groupName));
		} else {
			System.out.println("없는 그룹입니다.");
		}
	}
	
	// class method
	private <T> void printList(List<T> list){
		if(list.size() == 0){
			System.out.println("등록된 내용이 없습니다.");
		}
		for(T t : list){
			System.out.println(t);
		}
	}
	private String reInputGroupName(PhoneBook phoneBook, boolean bool){
		System.out.print((bool?"이미 존재하는 그룹명입니다.":"존재하지 않는 그룹명입니다.")+" 다시 입력해주세요. : ");
		String groupName = sc.next();
		if(phoneBook.hasGroupName(groupName) == bool){
			groupName = reInputGroupName(phoneBook, bool);
		}
		return groupName;
	}
}
