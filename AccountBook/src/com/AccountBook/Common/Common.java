package com.AccountBook.Common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Common {
	
	public static String getCat(String selectCategory) {
		/*(A) 住宅費　(B) 水道光熱費　(C) 通信費　(D) 保険料　(E) 車両費　(F) 保育料・学費・習い事　(G) 税金　(H) 小遣い　(I) その他（固定費）
		  (1) 食費　(2) 日用品　(3) 医療費　(4) こども費　(5) 被服・美容費　(6) 交際費　(7) 娯楽費　(8) 雑費　(9) 特別費　(10) その他（変動費)*/
		String category = null;
		
		if (selectCategory.matches("A|a")) category = "住宅費"; 
		
		else if (selectCategory.matches("B|b")) category = "水道光熱費";
		
		else if (selectCategory.matches("C|c")) category = "通信費";
		
		else if (selectCategory.matches("D|d")) category = "保険料";
		
		else if (selectCategory.matches("E|e")) category = "車両費";
		
		else if (selectCategory.matches("F|f")) category = "保育料・学費・習い事";
		
		else if (selectCategory.matches("G|g")) category = "税金";
		
		else if (selectCategory.matches("H|h")) category = "小遣い";
		
		else if (selectCategory.matches("I|i")) category = "その他（固定費）";
		
		else if (selectCategory.matches("1|１")) category = "食費";
		
		else if (selectCategory.matches("2|２")) category = "日用品";
		
		else if (selectCategory.matches("3|３")) category = "医療費";
		
		else if (selectCategory.matches("4|４")) category = "こども費";
		
		else if (selectCategory.matches("5|５")) category = "被服・美容費";
		
		else if (selectCategory.matches("6|６")) category = "交際費";
		
		else if (selectCategory.matches("7|７")) category = "娯楽費";
		
		else if (selectCategory.matches("8|８")) category = "雑費";
		
		else if (selectCategory.matches("9|９")) category = "特別費";
		
		else if (selectCategory.matches("10|１０")) category = "その他（変動費)";
		
		return category;
	}

	/*
	 * @param なし
	 * @return 現在日付（yyyy/MM/dd)
	 */
	public static String getDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		return sdf.format(calendar.getTime());
	}
}
