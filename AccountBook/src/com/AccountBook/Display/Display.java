package com.AccountBook.Display;

public class Display {
	
	public static void sectorMes(String mes) {
		
		
		System.out.println("********************************************************************************");
		
		int AsterNum = (70 - mes.length())/2; 
		
		for (int i = 1; i <= AsterNum; i++ ) {
			System.out.print("*");
		}
		System.out.print("   ");
		System.out.print(mes);
		System.out.print("   ");
		
		for (int i = 1; i <= AsterNum; i++ ) {
			System.out.print("*");
		}
		System.out.println();
		
		System.out.println("********************************************************************************");
		
	}

	public static void line(int line) {
		for(int i = 1; i<= line; i++) {
			System.out.println();
		}
	}
	
	public static void line() {
		System.out.println();
	}
	
}
