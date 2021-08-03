package page.elements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


abstract public class PageBaseClass {
	
	protected static WebDriver driver;
	protected static Actions act;
	protected WebDriverWait wait;
	private static final String URL = "http://demowebshop.tricentis.com/";
	
	public PageBaseClass() {
		
		if(driver == null)
			setup();
		
		act = new Actions(driver);
		wait = new WebDriverWait(driver, 5);
	}
	
	private  void setup() {
		if(driver == null)
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get(URL);
		}
	}
	
	public static void teardown() {
		
		if(driver !=null) {
			driver.close();
			driver = null;
		}
		
	}
	
	
	public static void mouseHover(WebElement ele) {
		
		act.moveToElement(ele).perform();
		
	}
	
	public void selectFromDropdown(WebElement sel, String visibleText) {
		
		Select select = new Select(sel);
		select.selectByVisibleText(visibleText);
		
	}

	public void jsClick(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ele);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
	}

}
