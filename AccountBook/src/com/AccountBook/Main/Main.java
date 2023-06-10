package com.AccountBook.Main;

import com.AccountBook.Login.*;

public class Main {

	public static void main(String[] args) {
		
		//Loginクラスloginメソッド呼び出し
		//引数:なし
		//戻り値；String型ファイル名
		
		System.out.println("<<TIPS>> プログラムの入力画面でExitと入力するとプログラムを終了できます");
		sleep(3000);
		
		
		String Filename = Login.login();
		
		//Print File name 
		
		System.out.println("Filename:" + Filename );
		//testing

	}
	public static void sleep(int num) {
		try {
			Thread.sleep(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
