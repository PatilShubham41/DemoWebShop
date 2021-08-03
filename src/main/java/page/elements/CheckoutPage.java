package page.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import page.utilities.Success;

public class CheckoutPage extends PageBaseClass {

	public CheckoutPage() {
		super();
	}
	
	public WebElement title() {
		return driver.findElement(By.tagName("h1"));
	}

	public WebElement country() {
		return driver.findElement(By.id("BillingNewAddress_CountryId"));
		
	}
	
	public WebElement city() {
		return driver.findElement(By.id("BillingNewAddress_City"));
	}
	
	public WebElement address() {
		return driver.findElement(By.id("BillingNewAddress_Address1"));
	}
	
	public WebElement zipCode() {
		return driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
	}
	
	public WebElement phoneNumber() {
		return driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
	}
	
	public WebElement continueBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='opc-billing']//input[@value='Continue']")));
		return driver.findElement(By.xpath("//li[@id='opc-billing']//input[@value='Continue']"));
	}
	
	public WebElement shippingContinue() {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='opc-shipping']//input[@value='Continue']")));
		return driver.findElement(By.xpath("//li[@id='opc-shipping']//input[@value='Continue']"));
	}
	
	public WebElement shippingMethodContinue() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='opc-shipping_method']//input[@value='Continue']")));
		return driver.findElement(By.xpath("//li[@id='opc-shipping_method']//input[@value='Continue']"));
	}
	
	public WebElement cashOnDelivery() {
		
		return driver.findElement(By.xpath("//input[@value='Payments.CashOnDelivery']"));
		
	}
	
	public WebElement paymentMethodContinue() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='opc-payment_method']//input[@value='Continue']")));
		return driver.findElement(By.xpath("//li[@id='opc-payment_method']//input[@value='Continue']"));
		
	}
	
	public WebElement paymentInfoContinue() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='opc-payment_info']//input[@value='Continue']")));
		return driver.findElement(By.xpath("//li[@id='opc-payment_info']//input[@value='Continue']"));
	}
	
	public WebElement confirmBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Confirm']")));
		return driver.findElement(By.xpath("//input[@value='Confirm']"));
	}
	
	
	public Success createNewInstance() {
		return new Success();
	}
}
