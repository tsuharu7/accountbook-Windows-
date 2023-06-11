package com.AccountBook.Display;

public class Display {
	
	public static void sectorMes(String mes) {
		
		
		System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
		
		int AsterNum = (58 - mes.length())/2; 
		
		for (int i = 1; i <= AsterNum; i++ ) {
			System.out.print("＊");
		}
		System.out.print("　");
		System.out.print(mes);
		System.out.print("　");
		
		for (int i = 1; i <= AsterNum; i++ ) {
			System.out.print("＊");
		}
		System.out.println();
		
		System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
		
	}
	
	public static void showTips() {
		System.out.println("<<TIPS>> プログラムの入力画面でExitと入力するとプログラムを終了できます");
		System.out.println("<<TIPS>> ここより先からは入力画面でCancelと入力すると処理をキャンセルしメニューへ戻ることができます");
	}
	
	public static void catList() {
		Println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊　　カテゴリー　　一覧　＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
		line();
		Println("　　　　　＜固定費＞　　　　　　　　　　　　　　　　　　　　＜変動費＞　　　　　　　　　　");
		line();
		Println("　　　　　(A) 住宅費　　　　　　　　　　　　　　　　　　　　　(1) 食費");
		Println("　　　　　(B) 水道光熱費　　　　　　　　　　　　　　　　　　　(2) 日用品");
		Println("　　　　　(C) 通信費　　　　　　　　　　　　　　　　　　　　　(3) 医療費");
		Println("　　　　　(D) 保険料　　　　　　　　　　　　　　　　　　　　　(4) こども費");
		Println("　　　　　(E) 車両費　　　　　　　　　　　　　　　　　　　　　(5) 被服・美容費");
		Println("　　　　　(F) 保育料・学費・習い事　　　　　　　　　　　　　　(6) 交際費");
		Println("　　　　　(G) 税金　　　　　　　　　　　　　　　　　　　　　　(7) 娯楽費");
		Println("　　　　　(H) 小遣い　　　　　　　　　　　　　　　　　　　　　(8) 雑費");
		Println("　　　　　(I) その他（固定費）　　　　　　　　　　　　　　　　(9) 特別費");
		Println("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　 (10) その他（変動費)");
		line();
		Println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊　以上　＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
		line();
	}

	public static void line(int line) {
		for(int i = 1; i<= line; i++) {
			System.out.println();
		}
	}
	
	public static void line() {
		System.out.println();
	}
	
	public static String getUserName(String FileName) {
		String[] FileNameSplit = FileName.split(",");
		String uName = FileNameSplit[0];
		return uName;
		
	}
	
	public static void Println(String Printer) {
		System.out.println(Printer);
	}
	
	public static void Print(String Printer) {
		System.out.print(Printer);
	}
	
}
