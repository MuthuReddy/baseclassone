package com.fbb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.collections4.functors.SwitchClosure;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HotelCustomerDetails {

	public static void main(String[] args) throws IOException {
		
	File file=new File("C:\\Users\\shank\\eclipse-workspace\\FbbLogin\\Excel\\Hotel customer Details.xlsx");
	FileInputStream stream = new FileInputStream(file);
	Workbook workbook = new XSSFWorkbook(stream);
	Sheet sheet = workbook.getSheet("Customer Details");
	for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
	Row row=sheet.getRow(i);
	for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
		Cell cell = row.getCell(j);
		System.out.println(cell);
		
		CellType type = cell.getCellType();
switch (type) {
		case NUMERIC:
		if(DateUtil.isCellDateFormatted(cell)) {
	    java.util.Date dateCellValue = cell.getDateCellValue();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yy");
		String format = dateFormat.format(dateCellValue);
		System.out.println(format);
		break;
	    }
switch (type) {
		case NUMERIC:
		double d = cell.getNumericCellValue();
		BigDecimal b=BigDecimal.valueOf(d);
		String num=b.toString();
		System.out.println(num);
		break;
		default:
		break;
	    }



		}
		
	}
	}
	}
	}