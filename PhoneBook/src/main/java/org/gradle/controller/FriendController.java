package org.gradle.controller;

import java.util.List;
import java.util.Scanner;

import org.gradle.domain.Friend;
import org.gradle.domain.User;
import org.gradle.repository.UserRepository;

public class FriendController extends Controller {
	private UserRepository userRepository = UserRepository.getInstance();
	
	private final String message = "1. 친구목록 보기\n2. 친구 검색\n3. 친구 추가\n4. 친구 삭제\n5. 나가기";
	private User user;

	public FriendController(Scanner sc) {
		super(sc);
	}
	
	public void play(User user){
		this.user = user;
		super.play(message, 5);
	}

	@Override
	public void searchMenu(int num) {
		if(num == 1){
			printList(user.getFriends());
		} else if(num == 2){
			searchFriends();
		} else if(num == 3){
			addFriend();
		} else if(num == 4){
			removeFriend();
		}
	}
	// view method
	private void removeFriend(){
		System.out.print("친구의 아이디를 입력해주세요. : ");
		Friend friend = user.findFriend(sc.next());
		if(friend == null){
			System.out.println("등록된 친구가 없습니다.");
		} else {
			if(!user.hasFriend(friend.getId())){
				System.out.println("존재하지 않는 친구입니다.");
				return;
			}
			System.out.println(friend);
			if(reYesOrNo("삭제하시겠습니까?")){
				user.removeFriend(friend);
			}
		}
	}
	private void addFriend(){
		System.out.print("친구의 아이디를 입력해주세요. : ");
		User findUser = userRepository.find(sc.next());
		if(findUser != null){
			if(user.hasFriend(findUser.getId())){
				System.out.println("이미 존재하는 친구입니다.");
				return;
			}
			System.out.println(findUser);
			if(reYesOrNo("추가하시겠습니까?")){
				user.addFriend(new Friend(findUser.getId(), findUser.getContcat()));
			}
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}
	private void searchFriends(){
		System.out.print("친구의 아이디를 입력해주세요. : ");
		List<Friend> friends = user.findFriends(sc.next());
		if(friends.isEmpty()){
			System.out.println("등록된 친구가 없습니다.");
		} else {
			printList(friends);
		}
	}

	// class method
	private boolean reYesOrNo(String message){
		System.out.print(message + "(yes, no) : ");
		String word = sc.next().toUpperCase();
		while(true){
			if("YES".equals(word)){
				System.out.println("삭제되었습니다.");
				break;
			} else if("NO".equals(word)){
				System.out.println("삭제가 취소되었습니다.");
				break;
			}
			System.out.println("다시 입력해주세요. : ");
			word = sc.next().toUpperCase();
		}
		return word.equals("YES")?true:false;
	}
	private <T> void printList(List<T> list){
		if(list.size() == 0){
			System.out.println("등록된 내용이 없습니다.");
		}
		for(T t : list){
			System.out.println(t);
		}
	}
}
