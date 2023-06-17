package com.AccountBook.Exit;

import com.AccountBook.Display.Display;
import com.AccountBook.logs.Logs;

public class Exit {
	
	// プログラム上でExitと入力するとプログラムを終了する処理(戻り値、引数なし）
	public static void exit() throws Exception {
		Display.line();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Logs.printDebugLog(new Object() {}.getClass().getEnclosingClass().getName(), "ログイン前のためユーザなし", "強制終了（Exit)しました");
		System.out.println("Exitが入力されたため、プログラムを終了します!");
		System.out.println("ご利用いただきありがとうございました。さようなら!");
		
		System.exit(0);
	}
	
	public static void exit(String FileName) throws Exception {
		
		Display.line(3);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Logs.printDebugLog(new Object() {}.getClass().getEnclosingClass().getName(), FileName, "強制終了（Exit)しました");
		System.out.println("Exitが入力されたため、プログラムを終了します!");
		System.out.println("ご利用いただきありがとうございました。さようなら!");
		
		System.exit(0);
	}
	
	

}
