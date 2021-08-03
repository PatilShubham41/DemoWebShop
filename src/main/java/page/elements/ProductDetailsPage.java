package page.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailsPage extends PageBaseClass {

	public ProductDetailsPage() {
		super();
		
	}
	
	public WebElement productTitle() {
		return driver.findElement(By.cssSelector("h1[itemprop='name']"));
	}
	
	public WebElement productPrice() {
		
		return driver.findElement(By.cssSelector("span[itemprop='price']"));
	}
	
	public WebElement quantity() {
		return driver.findElement(By.cssSelector("input.qty-input"));
	}
	
	public WebElement addToCart() {
		return driver.findElement(By.cssSelector("div.add-to-cart-panel>input[value='Add to cart']"));
	}
	
	public WebElement addToCompareList() {
		return  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Add to compare list']")));
		
	}
	
	public WebElement successMessage() {
		
		return driver.findElement(By.cssSelector("p.content"));
	}
	
	public WebElement apparelAndShoes() {
		
		return driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Apparel & Shoes')]"));
	}
	
	public WebElement addReview() {
		return driver.findElement(By.xpath("//a[text()='Add your review']"));
	}
	
	public WebElement addToWishList() {
		
		return driver.findElement(By.cssSelector("input[value='Add to wishlist']"));
		
	}
	
	public WebElement addedToWishListMessage() {
		return driver.findElement(By.cssSelector("p.content"));
	}
	
	public WebElement wishListLink() {
		return driver.findElement(By.cssSelector("p.content>a"));
	}
	
	
	

}
