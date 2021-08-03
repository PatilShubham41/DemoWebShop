package page.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WishListPage extends PageBaseClass{
	
	public WebElement title() {
		
		return driver.findElement(By.tagName("h1"));
	}
	
	public List<WebElement> wishListItem(){
		return driver.findElements(By.cssSelector("tr.cart-item-row"));
		
	}
	
	public List<WebElement> remove(){
		
		return driver.findElements(By.cssSelector("td.remove-from-cart>input"));
	}
	
	public WebElement updateWishList() {
		return driver.findElement(By.name("updatecart"));
	}
	
	public WebElement wishListContent() {
		return driver.findElement(By.cssSelector("div.wishlist-content"));
	}
}
