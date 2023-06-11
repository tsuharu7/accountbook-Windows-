package com.AccountBook.Login;

import java.util.Scanner;
import com.AccountBook.Display.*;
import com.AccountBook.Exit.*;
import com.AccountBook.File.*;


public class Login {
	
	public static String login() {
		outerloop:
			while(true) {
				Display.sectorMes("ようこそ！　アカウントブックへ！");
				Display.line(1);
				
				Scanner KB = new Scanner(System.in);
				
				String userName = null;
				String userPass = null;
				String fileName = null;
				
				loginloop:
					while(true) {
						Display.line(2);
						System.out.println("ユーザー名を入力してください（新規登録はNを入力)");
						System.out.print("入力：");
		
						String userNam = KB.nextLine();
						
						if (userNam.matches("N|n")) {
							SignUp.signup();
							break loginloop;
						}else if (userNam.matches("Exit|exit")) {
							Exit.exit();
						}else {
							userName = userNam;
						}
						
						Display.line(2);
						System.out.println("パスワードを入力してください");
						System.out.print("入力：");
		
						String userPas = KB.nextLine();
						
						if(userPas.matches("Exit|exit")) {
							Exit.exit();
						}else {
							userPass = userPas;
						}
						
						fileName = userName + "," + userPass;
						
						String feedBack = FileCom.SearchFile(fileName);
						
						if (feedBack == null) {
							System.out.println("ユーザー名またはパスワードが正しくありません。再度入力してください");
						} else {
							feedBack =fileName;
							return fileName;
						}
					}
			}
				
				
		
		
	}
	
	

}
