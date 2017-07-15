package org.gradle.controller;

import java.util.List;
import java.util.Scanner;

import org.gradle.common.Utils;
import org.gradle.domain.Contcat;
import org.gradle.domain.Group;

public class GroupController extends Controller {
	
	private Group group;
	private final String[] menus = {"연락처 보기", "연락처 추가", "연락처 검색", "연락처 삭제"};

	public GroupController(Scanner sc) {
		super(sc);
	}
	
	public void play(Group group){
		this.group = group;
		super.play(menus);
	}

	@Override
	public void searchMenu(int num) {
		if(num == 1){
			printList(group.getContcats());
		} else if(num == 2){
			addContcat(group);
		} else if(num == 3){
			System.out.print("검색할 내용을 입력해주세요 : ");
			List<Contcat> list = group.searchContcat(sc.next());
			list.add(new Contcat("name", "010-1234-1234"));
			printList(list);
		} else if(num == 4){
			deleteContcat(group);
		}
	}
	
	private static <T> void printList(List<T> list){
		if(list.size() == 0){
			System.out.println("등록된 내용이 없습니다.");
		}
		for(T t : list){
			System.out.println(t);
		}
	}
	
	private void addContcat(Group group){
		System.out.println("추가할 연락처를 입력해주세요.");
		Contcat contcat = inputNameAndNumber();
		if(group.hasContcat(contcat)){
			System.out.println("이미 등록된 연락처입니다.");
			return;
		}
		group.addContcat(contcat);
	}

	private void deleteContcat(Group group){
		System.out.println("삭제할 연락처를 입력해주세요. : ");
		Contcat contcat = inputNameAndNumber();
		if(!group.hasContcat(contcat)){
			System.out.println("없는 연락처입니다.");
			return;
		}
		group.deleteContcat(contcat);
		System.out.println("삭제되었습니다.");
	}
	
	private Contcat inputNameAndNumber(){
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("전화번호 : ");
		String number = sc.next();
		if(!Utils.numberCheck(number)){
			number = reInputNumber();
		}
		return new Contcat(name, number);
	}
	
	private String reInputNumber(){
		System.out.print("잘못된 전화번호입니다. 다시 입력해주세요. : ");
		String number = sc.next();
		if(!Utils.numberCheck(number)){
			number = reInputNumber();
		}
		return number;
	}
}
