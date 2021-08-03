package page.utilities;

import page.elements.ProductDetailsPage;

public class ProductDetails {

	ProductDetailsPage product;
	ExcelUtil ex;
	
	public ProductDetails(ProductDetailsPage product, ExcelUtil ex){
		
		this.product = product;
		this.ex = ex;

	}
	
	public void changeQuantity(int newQuantity) {
		
		product.quantity().clear();
		product.quantity().sendKeys(""+newQuantity);
		

	}
	
	public void clkAddToCart() {
		
		product.addToCart().click();
		product.addToCart().isDisplayed();

	}
	
	
	public void navigateToApparel() {
		
		product.apparelAndShoes().click();
	}
	
	public float getProductPrice() {
		return Float.parseFloat(product.productPrice().getText());
	}
	
	public CompareList addToCompareList() {
		product.addToCompareList().click();
		
		return new CompareList();
	}
	
	public Review clkAddReview() {
		
		product.addReview().click();
		
		return new Review();
	}
	
	public WishList addToWishList() {
		
		product.addToWishList().click();
		System.out.println(product.addedToWishListMessage().getText());
		product.wishListLink().click();
		
		return new WishList();	
	}
	
	
	
	
}
