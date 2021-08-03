package page.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import page.utilities.ExcelUtil;
import page.utilities.ShoppingCart;

public class CategoryPage extends PageBaseClass{

	public CategoryPage() {
		super();
	}
	
	public WebElement title() {
		
		return driver.findElement(By.tagName("h1"));
		
	}
	
	public WebElement sortBy() {
		
		return driver.findElement(By.id("products-orderby"));
	}
	
	public WebElement numOfPerPage() {
		return driver.findElement(By.id("products-pagesize"));
	}
	
	public WebElement viewAs() {
		return driver.findElement(By.id("products-viewmode"));
	}
	
	public WebElement productTitle(String title) {
		
		return driver.findElement(By.xpath("//h2[@class='product-title']/a[contains(text(),'"+title+"')]"));
	}
	
	public WebElement productDetailLink(int productNum) {
		
		return driver.findElement(By.xpath("//div[@class='item-box']["+productNum+"]//h2[@class='product-title']/a"));
		
	}
	
	public WebElement shoppingCart() {
		
		return driver.findElement(By.xpath("//div[@class='header-links']//a[@class='ico-cart']"));
	}
	
	public ShoppingCart getNewInstance(ExcelUtil ex) {
		
		return new ShoppingCart(ex);
	}
	
	public List<WebElement> itemsOnPage()
	{
		return driver.findElements(By.cssSelector("div.product-grid>div.item-box"));
	}
	
	public List<WebElement> itemsPrices(){
		return driver.findElements(By.cssSelector("span.price.actual-price"));
	}
	
	
}
