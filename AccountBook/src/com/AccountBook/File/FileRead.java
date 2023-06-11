package com.AccountBook.File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileRead {
	
	static final String userpath = ".\\UserData";
	
	public static ArrayList<String[]> getResult(String FileName) {
		
		ArrayList<String[]> reList = new ArrayList<String[]>();
		BufferedReader reader;
		String[] LineDat = null;
		
		
		try {
			reader = new BufferedReader(new FileReader(userpath+"\\"+FileName));
			String line = reader.readLine();

			while (line != null) {
				System.out.println(line);
				
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
