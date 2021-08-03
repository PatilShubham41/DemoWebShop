package page.utilities;


import org.openqa.selenium.WebElement;

import page.elements.ShoppingCartPage;

public class ShoppingCart {

	ShoppingCartPage cartPage;
	ExcelUtil ex;


	public ShoppingCart(ExcelUtil e) {

		cartPage = new ShoppingCartPage();
	
		ex = e;
	}

	public boolean verifyItem(int onRow) {
		return (cartPage.cartItems().get(onRow - 1).getText().contains(ex.getCellValue("Product", onRow + 1)))
				&& (cartPage.quantity(onRow).getAttribute("value")
						.contentEquals("" + (int) Double.parseDouble(ex.getCellValue("Quantity", onRow + 1))));

	}

	public int getNumOfItems() {

		return cartPage.cartItems().size();
	}

	public String getPageTitle() {

		return cartPage.pageTitle().getText();

	}

	public float getTotal(int row) {

		return (Float.parseFloat(cartPage.price(row).getText())
				* Integer.parseInt(cartPage.quantity(row).getAttribute("value")));

	}

	public Checkout clickCheckout() {

		cartPage.termsOfService().click();
		cartPage.checkout().click();

		return new Checkout();
	}
	
	public float itemPriceCalculated(int rowNum) {
		
		return Float.parseFloat(cartPage.subTotal().get(rowNum-1).getText());

	}

	public float doCartTotal() {

		float cartTotal = 0.0f;

		for (WebElement ele : cartPage.subTotal())
			cartTotal += Float.parseFloat(ele.getText());

		return cartTotal;
	}

	public float getCartTotal() {

		return Float.parseFloat(cartPage.cartTotal().getText());

	}

}
