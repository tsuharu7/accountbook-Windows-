package com.AccountBook.logs;

import com.AccountBook.File.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class Logs {
	//ログイン時に成功したファイル名を受け取り、ログインユーザー名、ログイン時間をログとして残す
	public static void loginLogs(String FileName) {
		
		String[] fileName = FileName.split(",");
		String userName = fileName[0];
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String curDatTime = dtf.format(now);
	    
		String sendLog = curDatTime + "," + userName + "," + "ログインしました";
		
		FileCom.logWrite(sendLog);
		
	}
	//ログアウト時に　ログインされた者のファイル名を受け取り、ログインユーザー名、ログアウト時間をログとして残す
	public static void logoutLogs(String FileName) {
		String[] fileName = FileName.split(",");
		String userName = fileName[0];
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String curDatTime = dtf.format(now);
	    
		String sendLog = curDatTime + "," + userName + "," + "ログアウトしました";
		
		FileCom.logWrite(sendLog);
	}
	//強制終了時（Exitが入力された）場合にログを残す(ログイン完了前もExitできるが、この場合はユーザー名を残さない）
	public static void exitLogs() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String curDatTime = dtf.format(now);
	    
		String sendLog = curDatTime + "," + "ログイン前のためユーザなし" + "," + "強制終了(Exit)しました";
		
		FileCom.logWrite(sendLog);
		
	}
	//強制終了時（Exitが入力された）場合にログを残す(ログイン完了前もExitできるが、この場合はユーザー名を残さない）
	public static void exitLogs(String FileName) {
		String[] fileName = FileName.split(",");
		String userName = fileName[0];
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String curDatTime = dtf.format(now);
	    
		String sendLog = curDatTime + "," + userName + "," + "強制終了（Exit)しました";
		
		FileCom.logWrite(sendLog);
		
	}

}
