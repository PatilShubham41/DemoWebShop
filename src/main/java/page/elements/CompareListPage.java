package page.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CompareListPage extends PageBaseClass {
	
	public WebElement title() {
		
		return driver.findElement(By.cssSelector("div.page-title>h1"));
	}
	
	public List<WebElement> items(){
		
		return driver.findElements(By.cssSelector("tr.overview>td.a-center"));
		
	}
	
	public List<WebElement> prices(){
		
		return driver.findElements(By.cssSelector("tr.product-price>td.a-center"));
	}

}
