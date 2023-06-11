package com.AccountBook.Main;

import java.io.IOException;
import java.util.Scanner;

import com.AccountBook.Display.Display;
import com.AccountBook.Features.Write;
import com.AccountBook.Features.Search.Search;
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
		
		//login ログを記録するメソッド呼び出し
		//引数：なし
		//戻り値:なしn
		Logs.printDebugLog(Class.class.getName(), Filename, "ログインしました");
		
		
	
		
		//メインメニューのセクション名を表示
		//引数:なし
		//戻り値:なし
		Display.sectorMes("メインメニュー");
		Display.line(2);
	
			while(true) {
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
					Write.fileWrite(Filename);
				}else if (uChoice.equals("L")){
					Display.line(1);
					System.out.println("ログアウトします");
					KB.close();
					Logs.printDebugLog(Class.class.getName(), Filename, "ログアウトしました");
					System.exit(0);
				}else {
					System.out.println("正しい選択を確認できませんでした");
				}
			}
		
		
		

	}
	public static void sleep(int num) throws SecurityException, IOException {
		try {
			Thread.sleep(num);
		} catch (InterruptedException e) {
			Logs.printErrorLog(e);
		}
	}

}
