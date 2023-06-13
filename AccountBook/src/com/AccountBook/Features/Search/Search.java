package com.AccountBook.Features.Search;

import java.util.ArrayList;
import java.util.Scanner;

import com.AccountBook.Display.Display;
import com.AccountBook.Exit.Exit;



public class Search {
	
	public static void CSearch(String FN) throws Exception {
		
		ArrayList<String[]> resultBack = new ArrayList<String[]>();
		programbreak:
			while(true) {
				Display.line();
				Display.showTips();
				Display.line();
				
				Scanner KB = new Scanner(System.in);
				Display.line();
				Display.sectorMes("検索　search");
				Display.line();
				
				System.out.println(Display.getUserName(FN)+"さんでログイン中");
				Display.line(2);
						
				String sChoice = null;
				String FileName = FN;
				
				
				
					while(true) {
						choiceloop:
							while(true) {
								Display.Println("ご希望の検索方法を選択してください:");
								Display.line(2);
								
								Display.Println("A: 全件表示（新しい項目から)で表示");
								Display.Println("B: 全件表示（古い　項目から)で表示");
								Display.Println("C; カテゴリー別で表示");
								Display.Println("D: 日付を指定して表示");
								Display.Println("E: 用語を入力して検索");
								
								Display.line(2);
								Display.Print("選択（A/B/C/D/E)：");
								sChoice = KB.nextLine();
								
								if (sChoice.matches("exit|Exit")) {
									Exit.exit(FileName);
								}else if (sChoice.matches("cancel|Cancel")) {
									break programbreak;
								}else if (sChoice.matches("A|a")) {
									resultBack = SearchAll.searchNew(FileName);
									break choiceloop;
									//全件検索（新しい項目から）
								}else if (sChoice.matches("B|b")) {
									resultBack = SearchAll.searchOld(FileName);
									break choiceloop;
									//全件検索（古い順から）
								}else if (sChoice.matches("C|c")) {
									//カテゴリー別で表示
								}else if (sChoice.matches("D|d")) {
									//月別で表示
								}else if (sChoice.matches("E|e")) {
									//用語を指定して検索
								}else {
									System.out.println("<<ERROR>> 正しくない入力です");
									System.out.println("<<TIPS>> 入力可能なのは　A/B/C/D/E/Exit/Cancel のみです");
								}
							}
						//結果の表示
				
						Display.line(2);
						Display.Println(resultBack.size()+"件の項目が見つかりました。");
						Display.line();
						Display.Println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊　結果　＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
						Display.Println("　　　利用日　　　|　　　カテゴリー　　　|　　　　　　　　　名前　　　　　　　　　|　　　　金額　　　　|");
						
						
						for (int i = 0; i<=resultBack.size(); i++) {
							String[] catchRes = resultBack.get(i);
							String date = catchRes[0];
							String group = catchRes[1];
							String name = catchRes[2];
							String cost = catchRes[3];
							
							//利用日
							System.out.print("　"+date+"　　");
							
							//カテゴリー
							int groupAster = (10-group.length())/2;
							for (int a =1; i<=groupAster; i++) {
								Display.Print("　");
							}
							System.out.print(group);
							for (int a =1; i<=groupAster; i++) {
								Display.Print("　");
							}
							Display.Print("　");
							
							//名前
							int nameAster =(20-name.length())/2;
							for (int a =1; i<=nameAster;i++) {
								Display.Print("　");
							}
							Display.Print(name);
							for (int a =1; i<=nameAster;i++) {
								Display.Print("　");
							}
							Display.Print("　");
							
							//料金
							int costAster = (10-cost.length())/2;
							for (int a =1; i<=costAster;i++) {
								Display.Print("　");
							}
							Display.Print(cost);
							for (int a =1; i<=costAster;i++) {
								Display.Print("　");
							}
							Display.Print("　");
							
							//改行
							System.out.println();
						}
						
						Display.Println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊　以上　＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
						
						Display.line(3);
						ovChoicebreak:
							while(true) {
								Display.Println("続けて検索しますか？");
								Display.line();
								Display.Println("(Y) はい。再度検索します");
								Display.Println("(N) いいえ。メインメニューへ戻ります");
								Display.line();
								Display.Print("入力:");
								
								String ovChoice = KB.nextLine();
								if (ovChoice.matches("exit|Exit")){
									Exit.exit(FileName);
								}else if (ovChoice.matches("y|Y")) {
									break ovChoicebreak;
								}else if (ovChoice.matches("n|N")) {
									break programbreak;
								}else {
									Display.Println("<<<ERROR>>> 正しい入力を確認できませんでした。");
									Display.Println("<<TIPS>> 入力できるのは Y/N/Exitのみです");
								}
							}
						
						
						
				}
		
			}
	}

}
