package page.utilities;

import org.openqa.selenium.WebElement;

import page.elements.WishListPage;

public class WishList {
	
	private WishListPage wishList;
	
	public WishList() {
		wishList = new WishListPage();
	}
	
	public String getPageTitle() {
		return wishList.title().getText();
	}
	
	public void removeAllFromWishList() {
		
		for(WebElement ele: wishList.remove()) {
			
			ele.click();
		}
		
		wishList.updateWishList().click();
	}
	
	public boolean isWishListEmpty() {
		
		if(wishList.wishListContent().getText().equals("The wishlist is empty!"))
			return true;

		
		return false;

	}
	
	public int numOfItemsInWishList() {
		return wishList.wishListItem().size();
	}

}
