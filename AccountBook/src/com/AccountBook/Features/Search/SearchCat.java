package com.AccountBook.Features.Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.AccountBook.Common.Common;
import com.AccountBook.Display.Display;
import com.AccountBook.Exit.Exit;
import com.AccountBook.File.FileRead;



public class SearchCat {
	
	public static ArrayList<String[]> searchCat(String FileName) throws Exception{
		Scanner KB = new Scanner(System.in);
		ArrayList<String[]> resBack = new ArrayList<String[]>();
		ArrayList<String[]> catBack = new ArrayList<String[]>();
		resBack = FileRead.getResult(FileName);
		String uCat = null;
		String rCat = null;
		programbreak:
			while(true) {
				
				
				CatChoice:
				while(true) {
					Display.line();
					Display.catList();
					Display.line();
					Display.Println("カテゴリー一覧から検索したカテゴリーを選択してください");
					Display.Print("選択：");
					uCat = KB.nextLine();
					
					if (uCat.matches("exit|Exit")) {
						Exit.exit(FileName);
					}else if (uCat.matches("cancel|Cancel")) {
						break programbreak;
					}else if (uCat.length()>1) {
						System.out.println("<<<ERROR>>>正しい選択を確認できませんでした。");
						System.out.println("<<TIPS>> 例えば　住宅費なら　A と　日用品なら 2 と　入力します");
					}else {
						rCat = Common.getCat(uCat);
						if (rCat == null) {
							System.out.println("<<<ERROR>>>正しい選択を確認できませんでした。");
							System.out.println("<<TIPS>> 例えば　住宅費なら　A と　日用品なら 2 と　入力します");
						}else {
							break CatChoice;
						}
					}
					
					for (int i =0; i<resBack.size();i++) {
						String[] resB = resBack.get(i);
						
						if (resB[1].equals(rCat)) {
							catBack.add(resBack.get(i));
						}else {
							
						}
					}
					break programbreak;
					
					
				}

			}
		Collections.reverse(catBack);
		return catBack;

		
	}

	
	
	

}
