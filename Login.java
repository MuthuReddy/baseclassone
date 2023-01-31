package com.fbb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		WebElement user = driver.findElement(By.name("email"));
		user.sendKeys("Muthu");
		WebElement pass = driver.findElement(By.name("pass"));
		pass.sendKeys("muthu");
}
}
