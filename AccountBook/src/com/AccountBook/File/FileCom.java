package com.AccountBook.File;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.AccountBook.logs.Logs;

/*
 * ファイル作成、削除、書き込み、検索を行う
 */

public class FileCom {
	
	//ファイル拡張子名
	static final String txt = ".txt";
	//ユーザーファイル作成時のパス指定
	static final String userpath = ".\\UserData";
	
	/*
	 * ファイル作成を行う
	 * @param ファイル名
	 * @return ファイル作成できた場合、true、それ以外false
	 */
	
	public static String CreateFile(String fileName) throws SecurityException, IOException {
		//ファイル作成できたか判定する文字列
		String result;
		checkDir(userpath);
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
			Logs.printErrorLog(e);
		} 
		
		return result;
	}
	
	/*
	 * ファイル検索を行う
	 * @param ファイル名
	 * @return ファイル名
	 */

     public static String SearchFile(String fileName) {
    	 //ユーザー名初期化
    	 String username = null;
    	 
    	 String searchPath = userpath + "\\" + fileName + txt;
    	 Path file = Paths.get(searchPath);
    	 
    	 if (Files.exists(file)) {
    		 /*
    		  * インデックス0：ユーザー名
    		  * 　　　　　　1：パスワード
    		  */
    		 String[] userList = fileName.split(",");
    		 username = userList[0];
    	 } 
    	 
    	 return username;
     }
     
     /*
      * ディレクトリ作成チェック
      * @param ディレクトリパス
      * @return なし
      */
     
     private static void checkDir(String userpath) {
    	 File dir = new File(userpath);
    	 
    	 if (!dir.exists()) {
    		 dir.mkdir();
    	 }
     }
}
