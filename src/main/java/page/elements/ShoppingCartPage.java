package page.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends PageBaseClass{

	public ShoppingCartPage() {
		super();

	}
	
	public WebElement pageTitle() {
		return driver.findElement(By.tagName("h1"));
	}

	
	public List<WebElement> cartItems(){
		
		return driver.findElements(By.cssSelector("td.product>a"));
	}
	
	public WebElement price(int row) {
		
		return driver.findElement(By.xpath("//tr["+row+"]//span[@class='product-unit-price']"));
	}
	
	public WebElement quantity(int row) {
		return driver.findElement(By.xpath("//tr["+row+"]//td[@class='qty nobr']/input"));
	}


	
	public WebElement termsOfService() {
		return driver.findElement(By.name("termsofservice"));
	}
	
	public WebElement checkout() {
		return driver.findElement(By.id("checkout"));
	}
	
	public List<WebElement> subTotal(){
		
		return driver.findElements(By.cssSelector("span.product-subtotal"));
	}
	
	public WebElement cartTotal() {
		return driver.findElement(By.cssSelector("span.product-price.order-total>strong"));
	}
	
	
}
