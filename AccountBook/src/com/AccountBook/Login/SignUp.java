package com.AccountBook.Login;

import java.io.IOException;
import java.util.Scanner;

import com.AccountBook.Display.Display;
import com.AccountBook.Exit.Exit;
import com.AccountBook.File.FileCom;
import com.AccountBook.logs.Logs;

public class SignUp {
	
	public static void signup() throws SecurityException, IOException {
		
		Display.line(1);
		//部分遷移メッセージの表示
		//戻り値：なし
		//引数：新規新規登録画面
		Display.sectorMes("新規登録画面");
		
		System.out.println();
		System.out.println("新規登録を開始します。ようこそ!");
		Display.line(1);
		Scanner KB = new Scanner(System.in);
		
		String userName;
		String userPass;
		
		userRegloop:
			while(true) {
				userNamloop:
					while(true) {
						Display.line(1);
						System.out.println("登録したいユーザー名を入力してください(20文字以内）");
						System.out.print("入力>");
	
						String userNam = KB.nextLine();
						
						Display.line();
						if(userNam==null || userNam.length()==0) {
							System.out.println("<<<ERROR>>>この項目を空白にはできません");
						}else if (userNam.matches("Exit|exit")) {
							Exit.exit();
						}else if (userNam.length()>20) {
							System.out.println("<<<ERROR>>> ユーザー名は20文字以内で入力してください");
						}else {
							userName = userNam;
							break userNamloop;
						}
					}
				userPasloop:
					while(true) {
						Display.line(1);
						System.out.println("登録したいパスワードを入力してください(20文字以内）");
						System.out.print("入力>");
	
						String userPas = KB.nextLine();
						
						Display.line();
						if(userPas==null||userPas.length()==0){
							System.out.println("<<<ERROR>>>この項目を空白にできません");
						}else if (userPas.matches("Exit|exit")) {
							Exit.exit();
						}else if (userPas.length()>20) {
							System.out.println("<<<ERROR>>> パスワードは20文字以内で入力してください");
						}else {
							userPass = userPas;
							break userPasloop;
						}
					}
				
				Display.line(2);
				
				String fileName = userName +"," + userPass;
				
				String feedBack = FileCom.CreateFile(fileName);
				
				if (feedBack.equals("success")){
					System.out.println("アカウント作成が完了しました.ようこそAccountBookの世界へ");
					 Logs.printDebugLog(Class.class.getName(), fileName, "新規アカウントを作成");
					System.out.println("新しく作成したアカウントでログインをお試しください");
					break userRegloop;
				}else if (feedBack.equals("exist")) {
					System.out.println("<<<ERROR>>>ユーザー名が既に存在しています。別のユーザー名をお試しください");
				}else if (feedBack.equals("error")) {
					System.out.println("<<<ERROR>>>登録にエラーが発生しました");
					System.out.println("<<<ERROR>>>#,$,%,&,@ などの登録できない文字が入力された可能性があります");
					System.out.println("<<<ERROR>>>別のユーザー名をお試しください");
				}
				
			
			}
		
			
	}

}
