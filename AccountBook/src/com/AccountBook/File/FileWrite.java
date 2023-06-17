package com.AccountBook.File;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.AccountBook.Common.Common;
import com.AccountBook.Display.Display;
import com.AccountBook.Exit.Exit;
import com.AccountBook.logs.Logs;

/**
 * 記入日、カテゴリ、名前、金額を書き込む
 *
 */
public class FileWrite {
	
	static String name;
	static String day;
	static String category;
	static int money; 
	
	/*
	 * @param ファイル名
	 * @return なし
	 */
	public static void fileWrite(String Filename) throws Exception {

		Logs.printDebugLog(new Object() {}.getClass().getEnclosingClass().getName() , Filename, "START:" + new Object() {}.getClass().getEnclosingMethod().getName()); 
		
		System.out.println("新規の出費の記帳を行います");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while (true) {
			
			try {
				//カテゴリ一覧表示
				Display.catList();
				
				System.out.println("登録したいカテゴリーを入力してください");
				System.out.print("入力：");
				final String selectCategory = br.readLine();
				System.out.println();
				
				
				category = Common.getCat(selectCategory);
				
				if (!category.equals(null)) {
					
					break;
						
				}
					
				
				
			} catch (IOException e) {
				Logs.printErrorLog(new Object() {}.getClass().getEnclosingClass().getName(), e.getMessage());
			}
		}
		
		System.out.println("利用日を登録してください（今日の場合はTと入力");
		
		
		while (true) {
			
			System.out.println("<<TIPS>>利用日が今日でない場合は西暦YYYY/月MM/日DDを入力（例2023/09/19）");
			System.out.print("入力：");
			day = br.readLine();
			System.out.println();
				
			if (day.replaceAll("/", "").matches("^[0-9]+$") && day.replaceAll("/", "").length() == 8) break;
			
			else if (day.matches("T|t")) {
				
				day = Common.getDate();
				break;
				
			}	
			System.out.println("入力値を以下の形式で入力してください（例2023/09/19）");
			System.out.println();
			
		}
		
		while (true) {
			
			System.out.println("名前を登録してください");
			System.out.print("名前：");
			
			name = br.readLine();
			System.out.println();
			if (name.matches("^[^ -~｡-ﾟ]+$") && name.length() <= 20) break;
		}
		
		
		System.out.println("金額を入力してください");
			
		System.out.print("金額：");
		try {
			money = Integer.parseInt(br.readLine());
				
		} catch (NumberFormatException e) {
			System.out.println("数値を入力してください");
			Logs.printErrorLog(new Object() {}.getClass().getEnclosingClass().getName(), e.getMessage());
		}
		
		if (!FileCom.SearchFile(Filename).equals(null)) {
			FileWriter fw = new FileWriter(FileCom.userpath +"\\"+ Filename + FileCom.txt, true);
			fw.write(day + "," + category + "," + name + "," + money + "\r\n");
			fw.close();
		} else {
			System.out.println("ファイルが存在しないため書き込みに失敗しました。");
		}
		
		while(true) {
			Display.Println("続けて登録しますか？");
			Display.line();
			Display.Println("(Y) はい。再度登録します");
			Display.Println("(N) いいえ。メインメニューへ戻ります");
			Display.line();
			Display.Print("入力:");
			
			String ovChoice = br.readLine();
			if (ovChoice.matches("exit|Exit")){
				Exit.exit(Filename);
			}else if (ovChoice.matches("y|Y")) {
				fileWrite(Filename);
				break;
			}else if (ovChoice.matches("n|N")) {
				
				break;
				
			}else {
				Display.Println("<<<ERROR>>> 正しい入力を確認できませんでした。");
				Display.Println("<<TIPS>> 入力できるのは Y/N/Exitのみです");
			}
		}
		


		Logs.printDebugLog(new Object() {}.getClass().getEnclosingClass().getName() , Filename, "END:" + new Object() {}.getClass().getEnclosingMethod().getName());
        
		
	}
	
}
