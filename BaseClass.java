package com.fbb;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver;
	
	//1.Enter URL
	public void enterUrl(String url) {
		driver.get(url);
	}

	//2.Maximize Window
	public void maximizewindow() {
		driver.manage().window().maximize();
	}
	
	//3.Insert value in Textbox
	public void elementSensKeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	//4.Click Button
	public void elementClick(WebElement element) {
		element.click();
	}

	//5.Alert OK
	public void alertOk() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	//6.Alert cancel
	public void alertCancel() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	//7.Text from Webpage
	public String elementGetText(WebElement element) {
		String text =element.getText();
		return text;
	}
	
	//8.Insert value from Textbox - 99%
	public String elementGetAttributeValue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;		
	}
	
	//8.1 Insert value from Textbox - 1%
	public String elementGetAttributeValue(WebElement element, String attribute) {
		String attribute1 = element.getAttribute("attribute");
		return attribute1;		
	}

	//9.Close all window
	public void quitWindow() {
		driver.quit();
	}

	//10.Close Window
	public void closeWindow() {
		driver.close();
	}
	
	//11.Get Title
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	//12.Enter URL
	public void enterApplnUrl(String url) {
		driver.get(url);
	}
	
	//13.Select dropdown option by text
	public void selectOptionByText(WebElement element, String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	//14.Select dropdown option by Attribute
	public void selectOptionByAttribute(WebElement element, String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	//15.Select dropdown option by text
	public void selectOptionByIndex(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
		}
		
	//16.Insert Value in Textbox by JS
	public void elementSendkeysJs(WebElement element, String data) {
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].setAttribute('value','"+data+"')", element);
		}
	
	//17.Click button by JS
	public void clickJs(WebElement element) {
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		}

	//18. Launch chrome Browser
	public void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	//19.switch to childwindow
	public void childWindow() {
		String windowHandle = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		for (String eachWindow : allwindow) {
			if(!windowHandle.equals(allwindow));
			driver.switchTo().window(eachWindow);			
		}
	}

	//20.Switch to Frame by Index
	public void switchToIndex(int index) {
		driver.switchTo().frame(index);
	}
		
	//21.Switch to Frame by FrameId
	public void switchToFrameId(String name) {
		driver.switchTo().frame(name);
	}
	
	//22.Find Loctor By Id
	public WebElement findElementId(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}
	
	//23.Find Locator By Name
	private WebElement findElementByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}
	
	//24.Find Locator By ClassName
	public WebElement findElementByClassName(String Value) {
		WebElement element = driver.findElement(By.className(Value));
		return element;
	}
	
	//25.Find Locator By xpath
	public WebElement findElementByXpath(String xpathExpression) {
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		return element;
	}
	
	//26.get All option from dropdown as Text
	public void getText(WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText("data");
		}
	
	//27.get Webpage Source
	public Object webpageSource() {
		String pageSource = driver.getPageSource();
		return pageSource;
	}
	
	//28.get All option from dropdown as Attribute Value
	public String getAttribute(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		return attribute;
	}
	
	//29.get All option from dropdown as FirstSelectOption
	public void firstSelectoption(WebElement element) {
		Select select = new Select(element);
		select.getFirstSelectedOption();
	}
	
	//30.dropdown isMultiple select option
	public boolean isMultiple(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}
		
	//37.Deselect by Index
	public void deselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}
	

	//38.ScrollUp Using JS
	public void scrollUpJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	
	//39.Thread Sleep
	public void threadSleep(long seconds) throws InterruptedException {
		Thread.sleep(seconds);
	}
	
	//40.Text from Alert
	public String alertText() {
		String text = driver.switchTo().alert().getText();
		return text;
	}
		
	//42.Deselect by Attribute
	public void deselectByAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);		
	}
	
	//43.Deselect by Text
	public void deselectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}
	
	//44.Deselect by All
	public void deselectByAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}
	
	//45.Back to Webpage
	public void back() {
		driver.navigate().back();
	}
	
	//46.get the Parent Window
	public String parentWindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	
	//47.get All Window
	public Set<String> allWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	//48.Clear Textbox
	public void clear(WebElement element) {
		element.clear();
	}
	
	//49.Take Screenshot
	public File takeScreenshot() {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File screenshotAs = ss.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}
	
	
	//50.Take Screenshot for Element
	public File takeScreenshotElement(WebElement element) {
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}
	

	//51.Forward to Webpage
	public void forward() {
		driver.navigate().forward();
	}
	
	//52.Mouse over action for Single Option
	public Actions mouseoverActionSingleOption(WebElement element) {
		Actions actions = new Actions(driver);
		Actions moveToElement = actions.moveToElement(element);
		return moveToElement;
	}
	
	//53.DragAndDrop
	public void dragAndDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target);
	}
	
	//54.Right Click
	public Actions rightClick() {
		Actions actions = new Actions(driver);
		Actions contextClick = actions.contextClick();
		return contextClick;
	}
	
	//55.Double Click
	public Actions doubleClick() {
		Actions actions = new Actions(driver);
		Actions doubleClick = actions.doubleClick();
		return doubleClick;
	}
	
	//56.Insert value in Textbox and Enter
	public void sendkeysAndEnter(WebElement element, String data) {
		element.sendKeys(data, Keys.ENTER);
	}
		
	//57.Refresh Page
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	//58.Robot using Down
	public void robotKeyPress() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}
	
	//59.ScrollDown Using JS
	public void scrollDownJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}	
}














