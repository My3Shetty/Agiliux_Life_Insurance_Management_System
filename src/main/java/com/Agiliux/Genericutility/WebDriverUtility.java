package com.Agiliux.Genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This Class contains WebDriver Specific reuseable actions
 * 
 * @author Maithri Shetty
 *
 */
public class WebDriverUtility {
	WebDriver WebDriver;

	/**
	 * This method is use for launch browser
	 * 
	 * @param browser
	 * @return
	 */
	public WebDriver launchbrowser(String browser) {
		WebDriver driver = null;
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.chromedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("You entered wrong Browser key in the proprty file");
			break;
		}
		return driver;
	}

	/**
	 * this method is use for maximise the browser
	 * 
	 * @param driver
	 */
	public void maximisebrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * this method is use to wait the conteroller implicitly till load
	 * 
	 * @param driver
	 * @param longTimeout
	 */

	public void implicitwaitTillPageLoad(WebDriver driver, long longTimeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	}

	/**
	 * this method is use for open the application
	 * 
	 * @param driver
	 * @param url
	 */
	public void navigateApplication(WebDriver driver, String url) {
		driver.get(url);
	}

	
	public WebElement convertDynamicXpathToWebElement(WebDriver driver,String tabName) {
		String dynamicXpath="//a[text()='%s']";
		String requriedXpath = String.format(dynamicXpath, tabName);
		return driver.findElement(By.xpath(requriedXpath));
		
	}
	/**
	 * this method is use for Opne the browser with Application
	 * 
	 * @param browser
	 * @param longTimeout
	 * @param url
	 * @return
	 */

	public WebDriver openBrowserwithApplication(String browser, long longTimeout, String url) {
		WebDriver driver = launchbrowser(browser);
		maximisebrowser(driver);
		implicitwaitTillPageLoad(driver, longTimeout);
		navigateApplication(driver, url);
		return driver;
	}

	/**
	 * This method is use to double click on webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleclick(WebDriver driver, WebElement element) {
		new Actions(driver).doubleClick(element).perform();
	}

	/**
	 * this method is use to close browser
	 * 
	 * @param driver
	 * @param driver
	 */

	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}

	/**
	 * this method is use to wait condtitions of Expilictwait
	 * 
	 * @param driver
	 * @param longTime
	 * @param element
	 */
	public void explicitwaituntillElement(WebDriver driver, long longTime, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is use to Swir=tch to any window based on window Title
	 * 
	 * @param driver
	 * @param PartialWindowTitle
	 */

	public void switchWindow(WebDriver driver, String PartialWindowTitle) {
		Set<String> windowId = driver.getWindowHandles();
		Iterator<String> it = windowId.iterator();

		while (it.hasNext()) {
			String WID = it.next();
			driver.switchTo().window(WID);
			String curentWndowTitle = driver.getTitle();
			if (curentWndowTitle.contains(PartialWindowTitle)) {
				break;
			}
		}
	}

	/**
	 * This method is use to Switch to Alert Window & click on OK button
	 * 
	 * @param driver
	 */
	public void swithToAlertWindowAndAccpect(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is use to switch to alert window & click on cancel button
	 * 
	 * @param driver
	 */

	public void swithToAlertWindowAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * used to Switch to Frame Window based on index
	 * 
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * 
	 * @param driver
	 * @param id_name_attribute
	 */
	public void swithToFrame(WebDriver driver, String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}

	/**
	 * used to select the value from the dropDwon based on index
	 * 
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This method is use to to select the value from the dropDwon based on value /
	 * option avlaible in GUI
	 * 
	 * @param element
	 * @param text
	 */

	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * used to place mouse cursor on specified element
	 * 
	 * @param driver
	 * @param elemnet
	 */ 
	public void mouseOverOnElemnet(WebDriver driver, WebElement elemnet) {

		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}

	/**
	 * used to right click on specified element
	 * 
	 * @param driver
	 * @param elemnet
	 */
	public void rightClickOnElement(WebDriver driver, WebElement elemnet) {
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}

	/**
	 * 
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver, String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript(javaScript, null);
	}

	public void waitAndClick(WebElement element) {
		int count = 0;
		while (count < 20) {
			try {
				element.click();
				break;
			} catch (Throwable e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				count++;
			}
		}
	}

	public void takeScreenShot(WebDriver driver, JavaUtility java,String className ) {
		String currentTime = java.currentTime();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/" +className+"_"+currentTime+ ".PNG");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String takeScreenShot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		return src;
	}

	/**
	 * pass enter Key appertain in to Browser
	 * 
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();

	}
}
