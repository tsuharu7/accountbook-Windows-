package com.AccountBook.Export;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.AccountBook.Common.Common;
import com.AccountBook.File.FileCom;

public class ExportData {
	
	/*
	 * @param
	 * @return
	 */
	public void exportData(String Filename) {
		
		String[] list = Filename.split(",");
		String username = list[0];
		String path = ".\\ExportFile\\";
		String xlsx = ".xlsx";
		
		FileCom.checkDir(path);
		
		//Book作成
		Workbook workbook = new XSSFWorkbook();
		//シート作成（シート名：ユーザー名）
		Sheet sheet = workbook.createSheet(username);
		
		
		try {
			//データファイルをまとめて読み込む
			BufferedReader br = new BufferedReader(new FileReader(FileCom.userpath + "\\" + Filename + FileCom.txt));
			
			String line;
			int rowNum = 0;
			
			//1行ずつ読み込む
			while ((line = br.readLine()) != null) {
				//データ分Bookの列を取得する
				Row row = sheet.createRow(rowNum++);
				
				String[] data = line.split(",");
				
				for (int i = 0; i < data.length; i++) {
					Cell cell = row.createCell(i);
					
					//セルにデータを書き込む
					cell.setCellValue(data[i]);
				}
				
				//出力ファイルを読み込ませる
				FileOutputStream fileOutputStream = new FileOutputStream(path + username + "_" + Common.getDate().replace("/", ""));
				
				//ブックに書き込む
				workbook.write(fileOutputStream);
				workbook.close();
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
