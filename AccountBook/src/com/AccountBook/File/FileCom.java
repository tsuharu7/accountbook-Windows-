package com.AccountBook.File;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * ファイル作成、削除、書き込み、検索を行う
 */

public class FileCom {
	
	//ファイル拡張子名
	static final String txt = ".txt";
	//ユーザーファイル作成時のパス指定
	static final String userpath = ".\\UserData";
	//ログファイル出力先パス
	static final String logpath = ".\\SystemsLogs\\log.txt";
	
	/*
	 * ファイル作成を行う
	 * @param ファイル名
	 * @return ファイル作成できた場合、true、それ以外false
	 */
	
	public static String CreateFile(String fileName) {
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
      * ログ書き込み
      * @param 文字列
      * @retrn なし
      */
     
     public static void logWrite(String sendLog) {
    	 
    	 try {
    		File logFile = new File(logpath);
    		
    		FileWriter fw = new FileWriter(logFile, true);
			
			fw.write(sendLog + "\r\n");
			
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
    	 
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
