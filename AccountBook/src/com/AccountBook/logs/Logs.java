package com.AccountBook.logs;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Logs {
	
	//ログファイル出力先パス
	private static final String DebugLogpath = ".\\SystemsLogs\\DebugLog.txt";
	//エラーログ出力先パス
	private static final String ErrorLogpath = ".\\SystemsLogs\\ErrorLog.txt";
	
	public static void printDebugLog(String className, String Filename, String message) throws SecurityException, IOException {
		String[] fileName = Filename.split(",");
		String userName = fileName[0];
		String msg = className + "  " + userName + "," + message;
		
		Logger logger = Logger.getLogger(className);
		
		FileHandler fh = new FileHandler(DebugLogpath, true);
		fh.setFormatter(new SimpleFormatter());
		logger.addHandler(fh);
		
		logger.setLevel(Level.INFO);
		removeConsoleHandler(logger);
		logger.log(Level.INFO, msg);
	}
	
	public static void printErrorLog(Object msg) throws SecurityException, IOException  {
        Logger logger = Logger.getLogger("Error");
		
		FileHandler fh = new FileHandler(ErrorLogpath, true);
		fh.setFormatter(new SimpleFormatter());
		logger.addHandler(fh);
		
		logger.setLevel(Level.INFO);
		removeConsoleHandler(logger);
		logger.log(Level.INFO, "エラーメッセージ", msg);
		
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
