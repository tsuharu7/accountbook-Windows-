package com.AccountBook.Features;

import com.AccountBook.Display.*;
import com.AccountBook.Exit.*;
import com.AccountBook.File.*;


public class Search {
	
	public static void Search(String FIleName) {
		
		Display.line();
		Display.sectorMes("検索　search");
		Display.line();
		
		System.out.println(Display.getUserName(FIleName)+"さんでログイン中");
		Display.line(2);
				
		String uChoice = null;
		
		choiceloop:
			while(true) {
				Display.Println("ご希望の検索方法を選択してください:");
				Display.line(2);
				
				Display.Println("A: 全件表示（新しい項目から)で表示");
				Display.Println("B: 全件表示（古い　項目から)で表示");
				Display.Println("C; カテゴリー別で表示");
				Display.Println("D: 月別で表示で表示");
				Display.Println("E: 用語を入力して検索");
			}
		
		
	
	}

}
