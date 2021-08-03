package page.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends PageBaseClass {

	public RegisterPage() {
		super();
	}


	public WebElement navigateTo() {

		return driver.findElement(By.xpath("//a[text()='Register']"));
	}


	public WebElement genderMale() {
		
		return driver.findElement(By.id("gender-male"));
	}

	public WebElement genderFemale() {
		return driver.findElement(By.id("gender-female"));
	}

	public WebElement firstName() {
		
		return driver.findElement(By.id("FirstName"));
	}

	public WebElement lastName() {
		
		return driver.findElement(By.id("LastName"));
	}

	public WebElement email() {
	
		return driver.findElement(By.id("Email"));
	}

	public WebElement password() {
		
		return driver.findElement(By.id("Password"));
	}

	public WebElement confirmPassword() {
		
		return driver.findElement(By.id("ConfirmPassword"));
	}

	public WebElement register() {
		
		return driver.findElement(By.id("register-button"));
	}




}
