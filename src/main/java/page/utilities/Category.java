package page.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import page.elements.CategoryPage;
import page.elements.ProductDetailsPage;

public class Category {

	CategoryPage category;
	ExcelUtil ex;

	ProductDetails prodDetail;
	CompareList compareList;
	public ArrayList<Float> pricesOnProductDetailsPage = new ArrayList<Float>();
	
	public Category() {

		category = new CategoryPage();
		ex = new ExcelUtil("apparel");

	}

	private boolean checkGreaterThanOrEqualTo(Number a, Number b) {

		return a.floatValue() <= b.floatValue();

	}

	public String getTitle() {
		return category.title().getText();
	}

	public ProductDetailsPage clickProduct(int row) {

		category.productTitle(ex.getCellValue("Product", row)).click();
		return new ProductDetailsPage();

	}

	public ProductDetails clkProduct(int prodNum) {

		category.productDetailLink(prodNum).click();
		return new ProductDetails(new ProductDetailsPage(), ex);
	}

	public void addToCart() {

		System.out.print("Number of rows without in excel: " + ex.getNumOfRowsWitoutHeader());

		for (int i = 2; i <= ex.getNumOfRowsWitoutHeader() + 1; i++) {

			prodDetail = new ProductDetails(clickProduct(i), ex);
			prodDetail.changeQuantity((int) Double.parseDouble(ex.getCellValue("Quantity", i)));
			prodDetail.clkAddToCart();
			prodDetail.navigateToApparel();

		}

	}

	public ShoppingCart navigateToCart() {

		category.shoppingCart().click();
		return category.getNewInstance(ex);

	}

	public void displayItemsPerPage(int count) {

		category.selectFromDropdown(category.numOfPerPage(), "" + count);

	}

	public int getItemsCountOnPage() {

		return category.itemsOnPage().size();
	}

	public void sortBy(String visibleText) {

		category.selectFromDropdown(category.sortBy(), visibleText);
	}

	public boolean isPricesSortedByAscending() {

		List<WebElement> prices = category.itemsPrices();

		for (int i = 0; i < prices.size() - 1; i++) {

			if (!(checkGreaterThanOrEqualTo(Float.parseFloat(prices.get(i).getText()),
					Float.parseFloat(prices.get(i).getText()))))
				return false;

		}

		return true;
	}

	
	
	// select product
	// it goes to product details get the price and click add to compare list
	// it goes to compare list page check the prices
	public CompareList addItemsToCompareList(int productSeqNum) {

	
			
			
			prodDetail = clkProduct(productSeqNum);
			System.out.println("Product " + productSeqNum + " prices on product details page: " + prodDetail.getProductPrice());
			pricesOnProductDetailsPage.add(0,prodDetail.getProductPrice());
			return prodDetail.addToCompareList();
			
			


	}

}
