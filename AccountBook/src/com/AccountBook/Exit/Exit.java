package com.AccountBook.Exit;

import com.AccountBook.Display.*;
import com.AccountBook.logs.*;

public class Exit {
	
	// プログラム上でExitと入力するとプログラムを終了する処理(戻り値、引数なし）
	public static void exit() {
		Display.line(3);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Logs.exitLogs();
		System.out.println("Exitが入力されたため、プログラムを終了します!");
		System.out.println("ご利用いただきありがとうございました。さようなら!");
		
		System.exit(0);
	}
	
	public static void exit(String FileName) {
		
		Display.line(3);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Logs.exitLogs(FileName);
		System.out.println("Exitが入力されたため、プログラムを終了します!");
		System.out.println("ご利用いただきありがとうございました。さようなら!");
		
		System.exit(0);
	}
	
	

}
