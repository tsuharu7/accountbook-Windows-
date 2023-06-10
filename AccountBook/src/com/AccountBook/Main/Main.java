package com.AccountBook.Main;

import com.AccountBook.Display.Display;
import com.AccountBook.Login.*;
import com.AccountBook.logs.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner KB = new Scanner(System.in);
		System.out.println("<<TIPS>> プログラムの入力画面でExitと入力するとプログラムを終了できます");
		sleep(3000);
		
		//Loginクラスloginメソッド呼び出し
		//引数:なし
		//戻り値；String型ファイル名
		String Filename = Login.login();
		
		//login ログを記録するメソッド呼び出し
		//引数：なし
		//戻り値:なし
		Logs.loginLogs(Filename);
		
		//メインメニューのセクション名を表示
		//引数:なし
		//戻り値:なし
		Display.sectorMes("メインメニュー");
		Display.line(2);
	
			while(true) {
				System.out.println("以下のメニューから実行するものを入力してください");
				Display.line(2);
				
				System.out.println("(T) テスト");
				System.out.println("(L) ログアウト");
				
				
				System.out.print("入力：");
				String uChoice = KB.next();
				
				if (uChoice.equals("T")) {
					System.out.println("TESTが選択されました");
				} else if (uChoice.equals("L")){
					Display.line(1);
					System.out.println("ログアウトします");
					Logs.logoutLogs(Filename);
					System.exit(0);
				}else {
					System.out.println("正しい選択を確認できませんでした");
				}
			}
		
		
		

	}
	public static void sleep(int num) {
		try {
			Thread.sleep(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
