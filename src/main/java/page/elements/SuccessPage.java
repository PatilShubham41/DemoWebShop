package page.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SuccessPage extends PageBaseClass {

	public SuccessPage() {
		super();
	}
	
	public WebElement successMessage() {
		return driver.findElement(By.tagName("strong"));
		
	}
	
	public WebElement continueBtn() {
		return driver.findElement(By.cssSelector("input[value='Continue']"));
	}
	
	
	public WebElement title() {
		return driver.findElement(By.xpath("//h1[text()='Thank you']"));
	}

}
