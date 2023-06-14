package com.AccountBook.File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileRead {
	
	//読み込みを行うデータ元
	static final String userpath = ".\\UserData";
	
	//ファイル名を受け取り、ファイルを一行づつ読み取り、String型の配列に入れ。その配列をArrayListに入れ戻り値として返すメソッド
	//引数：ファイル名String
	//戻り値：ファイル内容ＡｒｒａｙＬｉｓｔ
	public static ArrayList<String[]> getResult(String FileName) {
		
		ArrayList<String[]> reList = new ArrayList<String[]>();
		BufferedReader reader;
		String[] LineDat = null;
		
		
		try {
			reader = new BufferedReader(new FileReader(userpath+"\\"+FileName+".txt"));
			String line = reader.readLine();

			while (line != null) {
				String rLine = line;
				LineDat = rLine.split(",");
				reList.add(LineDat);
				// read next line
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return reList;

	}

}
