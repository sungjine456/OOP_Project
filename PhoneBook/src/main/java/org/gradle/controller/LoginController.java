package org.gradle.controller;

import java.util.Scanner;

import org.gradle.domain.User;

public class LoginController extends Controller {
	
	private PhoneBookController phoneBookController = new PhoneBookController(sc);
	private FriendController friendController = new FriendController(sc);
	
	private final String[] menus = {"전화번호 부", "친구"};
	private User user;

	public LoginController(Scanner sc) {
		super(sc);
	}
	
	public void play(){
		super.play(menus, "로그아웃");
	}
	
	@Override
	public void searchMenu(int num) {
		if(num == 1){
			phoneBookController.play(user);
		} else if(num == 2){
			friendController.play(user);
		}
	}
	
	public void login(User user){
		this.user = user;
		play();
	}
}
