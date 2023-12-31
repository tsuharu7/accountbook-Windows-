package com.AccountBook.File;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.AccountBook.logs.Logs;

/*
 * ファイル作成、削除、書き込み、検索を行う
 */

public class FileCom {
	
	//ファイル拡張子名
	public static final String txt = ".txt";
	//ユーザーファイル作成時のパス指定
	public static final String userpath = ".\\UserData";
	public static String FileName;
	/*
	 * ファイル作成を行う
	 * @param ファイル名
	 * @return ファイル作成できた場合、true、それ以外false
	 */
	
	public static String CreateFile(String fileName) throws Exception {
		Logs.printDebugLog(new Object() {}.getClass().getEnclosingClass().getName(), fileName, "START:" + new Object() {}.getClass().getEnclosingMethod().getName());
		
		//ファイル作成できたか判定する文字列
		String result;
		checkDir(userpath, fileName);
		//ファイルパス
		String path = userpath + "\\" + fileName + txt;
		
		//Fileオブジェクトを生成
		File file = new File(path);
		
		try {
			//ファイル作成できた場合、できなかった場合の処理
			if (file.createNewFile()) {
				result = "success";
				
				
			} else {
				result = "exist";
			}
		} catch (Exception e) {
			
			result = "error";
			Logs.printErrorLog(new Object() {}.getClass().getEnclosingClass().getName(), e.getMessage());
		} 
		
		
		Logs.printDebugLog(new Object() {}.getClass().getEnclosingClass().getName(), fileName, "END:" + new Object() {}.getClass().getEnclosingMethod().getName());
		return result;
	}
	
	/*
	 * ファイル検索を行う
	 * @param ファイル名
	 * @return ファイル名
	 */

     public static String SearchFile(String fileName) throws Exception {
    	 Logs.printDebugLog(new Object() {}.getClass().getEnclosingClass().getName(), fileName, "START:" + new Object() {}.getClass().getEnclosingMethod().getName());
    	 
    	 //ユーザー名初期化
    	 String username = null;
    	 
    	 String searchPath = userpath + "\\" + fileName + txt;
    	 Path file = Paths.get(searchPath);
    	 
    	 if (Files.exists(file)) {
   
    		 username = fileName;
    	 } 
    	 
    	 Logs.printDebugLog(new Object() {}.getClass().getEnclosingClass().getName(), fileName, "END:" + new Object() {}.getClass().getEnclosingMethod().getName());
    	 return username;
     }
     
     /*
      * ディレクトリ作成チェック
      * @param ディレクトリパス
      * @return なし
      */
     
     public static void checkDir(String userpath, String fileName) throws Exception {
    	 Logs.printDebugLog(new Object() {}.getClass().getEnclosingClass().getName(), fileName, "START:" + new Object() {}.getClass().getEnclosingMethod().getName());
    	 
    	 File dir = new File(userpath);
    	 
    	 if (!dir.exists()) {
    		 dir.mkdir();
    	 }
    	 
    	 Logs.printDebugLog(new Object() {}.getClass().getEnclosingClass().getName(), "", "END:" + new Object() {}.getClass().getEnclosingMethod().getName());
     }
}
