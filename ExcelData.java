
	package com.fbb;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
    import java.io.FileOutputStream;
    import java.io.IOException;
	import java.sql.Date;
	import java.text.SimpleDateFormat;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.RichTextString;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelData {
	public String getDatafromCell(String sheetName, int rownum, int cellnum) throws IOException {
		String res=null;
		File file=new File("C:\\Users\\shank\\eclipse-workspace\\FbbLogin\\Excel\\Hotel customer Details.xlsx");
		FileInputStream fileInputStream=new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row=sheet.getRow(rownum);
		Cell cell=row.getCell(cellnum);
		CellType type=cell.getCellType();
		
		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)) {
			    java.util.Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yy");
				res = dateFormat.format(dateCellValue);
				}
		else {
				double numericCellValue = cell.getNumericCellValue();
				long check=Math.round(numericCellValue);
				if(check==numericCellValue) {
				res=String.valueOf(check);
				}
				else {
				res=String.valueOf(numericCellValue);
				}
			}
			break;
		 default:
		break;
		}
		return res;	
	}
	
	
	public void updateCellData(String sheetName, int rownum, int cellnum, String oldData, String newData) throws IOException {
		File file=new File("C:\\Users\\shank\\eclipse-workspace\\FbbLogin\\Excel\\Hotel customer Details.xlsx");
		FileInputStream fileInputStream=new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row=sheet.getRow(rownum);
		Cell cell=row.getCell(cellnum);
        String value=cell.getStringCellValue();
        if(value.equals(oldData)) {
        cell.setCellValue(newData);
        FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
        } 
	}
	
	
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


