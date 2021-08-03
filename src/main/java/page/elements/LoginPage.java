package page.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBaseClass{

	public LoginPage() {
		super();
	}

	
	public WebElement navigateTo() {

		return driver.findElement(By.xpath("//a[text()='Log in']"));
	}
	
	public WebElement email()
	{
		return driver.findElement(By.id("Email"));
	}
	
	public WebElement password() {
		return driver.findElement(By.id("Password"));
	}
	
	public WebElement logOut() {
		return driver.findElement(By.xpath("//a[text()='Log out']"));
	}
	
	public WebElement continueBtn() {
		
		return driver.findElement(By.cssSelector("input[value='Continue']"));
	}

	public WebElement login() {
		return driver.findElement(By.cssSelector("input[value='Log in']"));
	}
	
	
}
