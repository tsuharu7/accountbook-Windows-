package com.AccountBook.logs;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
 * ログを記録する
 */
public class Logs {
	
	//ログファイル出力先パス
	private static final String DebugLogpath = "C:\\AccountBook\\Logs\\DebugLog.txt";
	//エラーログ出力先パス
	private static final String ErrorLogpath = "C:\\AccountBook\\Logs\\ErrorLog.txt";
	
	
	/*
	 * ログ出力機能
	 * @param クラス名、ファイル名、メッセージ
	 * @return なし
	 */
	public static void printDebugLog(String className, String Filename, String message) throws Exception {
		String[] fileName = Filename.split(",");
		String userName = fileName[0];
		String msg = className + "  " + "ユーザー名：" + userName + " メッセージ：" + message;
		
		Logger logger = Logger.getLogger(className);
		
		FileHandler fh = new FileHandler(DebugLogpath, true);
		fh.setFormatter(new SimpleFormatter());
		logger.addHandler(fh);
		
		logger.setLevel(Level.INFO);
		removeConsoleHandler(logger);
		logger.log(Level.INFO, msg);
		
		//クローズ処理
		fh.close();
	}
	
	/*
	 * エラーログ出力機能
	 * @param クラス名、メッセージ
	 * @return なし
	 */
	public static void printErrorLog(String className, String msg) throws Exception  {
        Logger logger = Logger.getLogger("Error");
		
		FileHandler fh = new FileHandler(ErrorLogpath, true);
		fh.setFormatter(new SimpleFormatter());
		logger.addHandler(fh);
		
		logger.setLevel(Level.ALL);
		removeConsoleHandler(logger);
		logger.log(Level.ALL, "エラー", msg);
		
		//クローズ処理
		fh.close();
		
	}
	
	private static void removeConsoleHandler(Logger logger) {
	     Handler[] handlerArr = logger.getHandlers();
	     for (Handler handler : handlerArr) {
	       if (handler instanceof ConsoleHandler) {
	         logger.removeHandler(handler);
	       }
	     }
	     // 再帰
	     Logger parentLogger = logger.getParent();
	     if (parentLogger != null) {
	       removeConsoleHandler(parentLogger);
	     }
	}

}
