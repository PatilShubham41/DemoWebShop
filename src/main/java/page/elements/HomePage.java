package page.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageBaseClass {

	public HomePage() {
		super();
	}

	
	public WebElement apparelAndShoes() {
		return driver.findElement(By.xpath("//a[contains(text(),'Apparel & Shoes')]"));
	}
	
	public WebElement electronics() {
		return driver.findElement(By.xpath("//a[contains(text(),'Electronics')]"));
	}
	
	public WebElement camera() {
		
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Camera, photo')]")));
	}
	
	public WebElement cellPhones() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Cell phones')]")));
	}
	

}
