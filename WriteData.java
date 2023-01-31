package com.fbb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {
	public void writeCellData(String sheetName, int rownum, int cellnum, String data) throws IOException {
		File file=new File("C:\\Users\\shank\\eclipse-workspace\\FbbLogin\\Excel\\Hotel customer Details.xlsx");
		FileInputStream fileInputStream=new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row=sheet.getRow(rownum);
		Cell cell=row.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}
}
