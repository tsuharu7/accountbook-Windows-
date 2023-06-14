package com.AccountBook.Display;

public class ResultDisplay {
	
	public static void searchResD(String date, String group, String name, String price) {
		
		
		
	}
	
	public static String toFullWidth(String s) {
		  StringBuilder sb = new StringBuilder(s);
		  for (int i = 0; i < s.length(); i++) {
		    char c = s.charAt(i);
		    if (0x30 <= c && c <= 0x39) {
		      sb.setCharAt(i, (char) (c + 0xFEE0));
		    }
		  }
		  return sb.toString();
	}
	
	public static String toHalfWidth(String s) {
		  StringBuilder sb = new StringBuilder(s);
		  for (int i = 0; i < s.length(); i++) {
		    char c = s.charAt(i);
		    if (0xFF10 <= c && c <= 0xFF19) {
		      sb.setCharAt(i, (char) (c - 0xFEE0));
		    }
		  }
		  return sb.toString();
		}
	
	
}
