package com.AccountBook.Main;

import java.util.Scanner;

import com.AccountBook.Display.Display;
import com.AccountBook.Features.Search.Search;
import com.AccountBook.File.FileWrite;
import com.AccountBook.Login.Login;
import com.AccountBook.logs.Logs;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner KB = new Scanner(System.in);
		System.out.println("<<TIPS>> プログラムの入力画面でExitと入力するとプログラムを終了できます");
		Display.line();
		sleep(3000);
	
		
		//Loginクラスloginメソッド呼び出し
		//引数:なし
		//戻り値；String型ファイル名
		String Filename = Login.login();

			while(true) {
				
				//メインメニューのセクション名を表示
				//引数:なし
				//戻り値:なし
				Display.line(2);
				Display.sectorMes("メインメニュー");
				Display.line(2);
			
				
				System.out.println("以下のメニューから実行するものを入力してください");
				Display.line(2);
				
				System.out.println("(S) 家計簿の内容を検索");
				System.out.println("(W) 家計簿の記帳");
				System.out.println("(L) ログアウト");

				
				
				System.out.print("入力：");
				String uChoice = KB.next();
				
				if (uChoice.equals("S")) {
					Search.CSearch(Filename);
				}else if (uChoice.equals("W")) {
					FileWrite.fileWrite(Filename);
				}else if (uChoice.equals("L")){
					Display.line(1);
					System.out.println("ログアウトします");
					KB.close();
					Logs.printDebugLog(new Object() {}.getClass().getEnclosingClass().getName(), Filename, "ログアウトしました");
					System.exit(0);
				}else {
					System.out.println("正しい選択を確認できませんでした");
				}
			}
		
		
		

	}
	public static void sleep(int num) throws Exception {
		try {
			Thread.sleep(num);
		} catch (InterruptedException e) {
			Logs.printErrorLog(new Object() {}.getClass().getEnclosingClass().getName(), e.getMessage());
		}
	}

}
