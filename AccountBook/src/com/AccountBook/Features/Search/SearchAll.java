package com.AccountBook.Features.Search;

import java.util.ArrayList;
import java.util.Collections;
import com.AccountBook.File.*;


public class SearchAll {
	
	public static ArrayList<String[]> searchOld(String FileName){
		
		ArrayList<String[]> resultSend = new ArrayList<String[]>();
		
		resultSend = FileRead.getResult(FileName);
		return resultSend;
	}
	
	public static ArrayList<String[]> searchNew(String FileName){
		
		ArrayList<String[]> resultSend = new ArrayList<String[]>();
		resultSend = FileRead.getResult(FileName);
		Collections.reverse(resultSend);
		return resultSend;
		
	}

}
