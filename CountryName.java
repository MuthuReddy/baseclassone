package com.fbb;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountryName {
	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://omrbranch.com/apitestingtraininginchennaiomr");
		WebElement country = driver.findElement(By.id("country-list"));
		country.click();
		Select select=new Select(country);
		java.util.List<WebElement> options = select.getOptions();
		
		for (WebElement a : options) {
			String text=a.getText();
			System.out.println(text);
		}
		
		File file=new File("C:\\\\Users\\\\shank\\\\eclipse-workspace\\\\FbbLogin\\\\Excel\\\\Hotel customer Details.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.createSheet("Country Name");
		
		for (int i = 0; i < options.size(); i++) {
			String text=options.get(i).getText();
			sheet.createRow(i).createCell(0).setCellValue(text);
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
