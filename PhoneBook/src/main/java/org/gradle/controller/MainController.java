package org.gradle.controller;

import java.util.Scanner;

import org.gradle.common.StringUtils;
import org.gradle.common.Utils;
import org.gradle.domain.Contcat;
import org.gradle.domain.User;
import org.gradle.repository.UserRepository;

public class MainController extends Controller {
	private UserRepository userRepository = UserRepository.getInstance();
	private LoginController loginController = new LoginController(sc);
	
	private final String message = "1. 로그인 \n2. 회원가입\n3. 종료";
	
	public MainController(Scanner sc){
		super(sc);
	}
	
	public void play(){
		super.play(message, 3);
	}
	
	@Override
	public void searchMenu(int num){
		System.out.print("아이디를 입력해주세요.");
		String id = sc.next();
		System.out.print("비밀번호를 입력해주세요.");
		String password = sc.next();
		
		if(num == 1){
			loginForm(id, password);
		} else if(num == 2){
			save(id, password);
		}
	}
	
	// view method
	private void loginForm(String id, String password){
		if(idAndPasswordCheck(id, password)){
			loginController.login(userRepository.find(id));
		}
	}
	private void save(String id, String password){
		userRepository.save(new User(id, password, inputNameAndNumber()));
		System.out.println(userRepository.find(id));
		loginController.login(userRepository.find(id));
	}

	// class method
	private boolean idAndPasswordCheck(String id, String password){
		User user = userRepository.find(id);
		
		if(user != null && StringUtils.equals(user.getPassword(), password)){
			return true;
		}
		return false;
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
