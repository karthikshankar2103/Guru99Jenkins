package com.data.provider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static void customerId(LinkedHashMap<String, String> map) {

		Workbook wb = new XSSFWorkbook();
		Sheet createSheet = wb.createSheet();

		Set<Entry<String, String>> entrySet = map.entrySet();
		int i = 1;
		for (Entry<String, String> s : entrySet) {
			createSheet.createRow(i).createCell(0).setCellValue(s.getKey());
			createSheet.createRow(i).createCell(1).setCellValue(s.getValue());
			i++;
		}
		OutputStream out=null;
		try {
			out = new FileOutputStream("./Excel/logins.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb.write(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
