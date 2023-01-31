package com.fbb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HotelBooking {
	public static void main(String[] args) throws IOException, InterruptedException {
	HotelBooking booking = new HotelBooking();
	booking.book();
	}
		public void book() throws IOException, InterruptedException {
		BaseClass baseClass=new BaseClass()	;
		ExcelData data = new ExcelData();
		baseClass.getDriver();
		baseClass.enterApplnUrl("https://adactinhotelapp.com/");
		baseClass.maximizewindow();
		WebElement txtUser = baseClass.findElementId("username");
		String name = data.getDatafromCell("Adactin", 1, 0);
		baseClass.elementSendkeysJs(txtUser, name);
		WebElement txtpass = baseClass.findElementId("password");
		String pass = data.getDatafromCell("Adactin",1, 1);
		baseClass.elementSendkeysJs(txtpass, pass);
		WebElement btnLogin = baseClass.findElementId("login");
		baseClass.elementClick(btnLogin);
		Thread.sleep(1000);
		WebElement location = baseClass.findElementId("location");
		baseClass.selectOptionByText(location, "London");
		Thread.sleep(1000);
		WebElement hotels = baseClass.findElementId("hotels");
		baseClass.selectOptionByText(hotels, "Hotel Creek");
		WebElement room = baseClass.findElementId("room_type");
		Thread.sleep(1000);
		baseClass.selectOptionByText(room, "Double");
		WebElement rooms = baseClass.findElementId("room_nos");
		baseClass.selectOptionByText(rooms, "1 - One");
		WebElement date = baseClass.findElementId("datepick_in");
		baseClass.elementSendkeysJs(date, "15/01/2023");
		Thread.sleep(1000);
		WebElement date1 = baseClass.findElementId("datepick_out");
		baseClass.elementSendkeysJs(date1, "20/01/2023");
		WebElement adults = baseClass.findElementId("adult_room");
		baseClass.selectOptionByText(adults, "2 - Two");
		WebElement child = baseClass.findElementId("child_room");
		baseClass.selectOptionByText(child, "1 - One");
		Thread.sleep(1000);
		WebElement submit = baseClass.findElementId("Submit");
		submit.click();
		Thread.sleep(1000);
		WebElement radio = baseClass.findElementId("radiobutton_0");
		radio.click();
		WebElement continue1 = baseClass.findElementId("continue");
		continue1.click();
		WebElement firstName = baseClass.findElementId("first_name");
		baseClass.elementSendkeysJs(firstName, "Muthu");
		Thread.sleep(1000);
		WebElement lastName = baseClass.findElementId("last_name");
		baseClass.elementSendkeysJs(lastName, "Reddy");
		Thread.sleep(1000);
		WebElement address = baseClass.findElementByXpath("//textarea[@id='address']");
		baseClass.elementSensKeys(address, "Chennai");
		Thread.sleep(1000);
		WebElement credit = baseClass.findElementId("cc_num");
		baseClass.elementSendkeysJs(credit, "4532657456366543");
		Thread.sleep(1000);
		WebElement creditType = baseClass.findElementId("cc_type");
		baseClass.selectOptionByText(creditType, "VISA");
		Thread.sleep(1000);
		WebElement expMonth = baseClass.findElementId("cc_exp_month");
		baseClass.selectOptionByText(expMonth, "September");
		Thread.sleep(1000);
		WebElement expyr = baseClass.findElementId("cc_exp_year");
		baseClass.selectOptionByText(expyr, "2022");
		Thread.sleep(1000);
		WebElement cvv = baseClass.findElementId("cc_cvv");
		baseClass.elementSendkeysJs(cvv, "299");
		WebElement bookNow = baseClass.findElementId("book_now");
		bookNow.click();
		Thread.sleep(1000);
		WebElement txtorderid = baseClass.findElementId("order_no");
        String string = txtorderid.getAttribute("value");
        data.writeCellData("Adactin", 1, 5, string);  
		
	}

}
