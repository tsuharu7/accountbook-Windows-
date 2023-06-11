package com.AccountBook.Features;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.AccountBook.Common.Common;
import com.AccountBook.Display.Display;
import com.AccountBook.Exit.Exit;
import com.AccountBook.File.FileCom;
import com.AccountBook.logs.Logs;

/**
 * ID、記入日、カテゴリ、名前、金額を書き込む
 *
 */
public class Write {
	static int count1 = 0;
	static int count2 = 0;
	
	static String name;
	static String day;
	static String category;
	static int money; 
	/*
	 * IDを自動生成する
	 */
	public static void fileWrite(String Filename) throws Exception {
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
				count1++;
				
				//カテゴリー入力値チェック・10回間違えたら強制終了
				if (count1 <= 11) Exit.exit(Filename);;
				category = Common.getCat(selectCategory);
				
				if (!category.equals(null)) {
					
					break;
						
				}
					
				
				
			} catch (IOException e) {
				Logs.printErrorLog(e);
			}
		}
		
		System.out.println("利用日を登録してください（今日の場合はTと入力");
		
		
		while (true) {
			
			System.out.println("<<TIPS>>利用日が今日でない場合は西暦YYYY/月MM/日DDを入力（例2023/09/19）");
			System.out.print("入力：");
			day = br.readLine();
			System.out.println();
			count2++;
			if (count2 <= 11) Exit.exit(Filename);
				
			if (day.replaceAll("/", "").matches("^[0-9]+$") && day.replaceAll("/", "").length() == 8) break;
			
			else if (day.matches("T|t")) {
				Calendar calendar = Calendar.getInstance();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
				day = sdf.format(calendar.getTime());
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
			Logs.printErrorLog(e.getMessage());
		}
			
		
		
		File file = new File(FileCom.userpath + "\\" + Filename + FileCom.txt);
		
		if (!FileCom.SearchFile(Filename).equals(null)) {
			FileWriter fw = new FileWriter(file, true);
			fw.write(day + "," + category + "," + name + "," + money);
		} else {
			System.out.println("ファイルが存在しないため書き込みに失敗しました。");
		}
		
	}
	
}
