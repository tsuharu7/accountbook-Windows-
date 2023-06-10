package com.AccountBook.Main;

public class Main {

	public static void main(String[] args) {
		
		//Loginクラスloginメソッド呼び出し
		//引数:なし
		//戻り値；String型ファイル名
		
		String Filename = Login.login();
		
		//Print File name 
		
		System.out.println("Filename:" + Filename );
		//testing

	}

}
