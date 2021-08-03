package testcases;

import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import extent.reports.MyAssertion;
import page.elements.PageBaseClass;
import page.utilities.Category;
import page.utilities.Checkout;
import page.utilities.CompareList;
import page.utilities.Home;
import page.utilities.Login;
import page.utilities.ProductDetails;
import page.utilities.Registration;
import page.utilities.Review;
import page.utilities.ShoppingCart;
import page.utilities.Success;
import page.utilities.WishList;
import test.base.BaseTest;

public class TestScenarios extends BaseTest {

	@BeforeMethod
	public void setup() {

		Registration register = new Registration();
		register.register(); // Register a new user
		Login log = new Login();
		log.doLogin(); // login with the same user

	}

	@AfterMethod
	public void tearDown() {

		PageBaseClass.teardown();
		MyAssertion.changeTest();

	}

	@Test(priority = 1, enabled = true)
	public void scenarioCheckOutProcess() {

		Home home = new Home();
		Category category = new Category();

		home.navigateToApparelAndShoes(); // navigating to apparel and shoes section
		MyAssertion.assertEquals(category.getTitle(), "Apparel & Shoes", "Category Page title"); // checking the page is
																									// loaded
		category.addToCart(); // adding 5 items to cart

		ShoppingCart cart = category.navigateToCart(); // Navigating to shopping cart
		MyAssertion.assertEquals(cart.getPageTitle(), "Shopping cart", "Cart page title"); // checking the page title
		MyAssertion.assertEquals(cart.getNumOfItems(), 4, "Assertion for number of items in cart"); // checking the
																									// number of items
																									// in cart
		MyAssertion.assertTrue(cart.verifyItem(1), "First item of cart"); // verifying first item and
																			// quantity from excel
		MyAssertion.assertTrue(cart.verifyItem(2), "Second item of cart");
		MyAssertion.assertTrue(cart.verifyItem(3), "Third item of cart"); // verifying third item and
																			// quantity from excel
		MyAssertion.assertTrue(cart.verifyItem(4), "Fourth item of cart");
		MyAssertion.assertTrue(cart.verifyItem(5), "Fifth item of cart"); // verifying fifth item and
																			// quantity from excel
		MyAssertion.assertEquals(cart.getTotal(1), cart.itemPriceCalculated(1), "First item price"); // Checking the
																										// total for
																										// first item
		MyAssertion.assertEquals(cart.getTotal(2), cart.itemPriceCalculated(2), "Second item price");
		MyAssertion.assertEquals(cart.getTotal(3), cart.itemPriceCalculated(3), "Third item price");
		MyAssertion.assertEquals(cart.getTotal(4), cart.itemPriceCalculated(4), "Fourth item price");
		MyAssertion.assertEquals(cart.getTotal(5), cart.itemPriceCalculated(5), "Fifth item price");
		MyAssertion.assertEquals(cart.doCartTotal(), cart.getCartTotal(), "Cart total");

		Checkout checkout = cart.clickCheckout(); // Checking out
		MyAssertion.assertEquals(checkout.getPageTitle(), "Checkout", "Checkout Page title"); // Checking the title of
																								// page

		Success success = checkout.checkout(); // fill all details
		MyAssertion.assertEquals(success.pageTitle(), "Thank you", "Succes Page title"); // Checking the success page
																							// title
		MyAssertion.assertEquals(success.getSuccessMessage(), "Your order has been successfully processed!",
				"Success Page Message");

	}

	@Test(priority = 2, enabled = true)
	public void scenarioValidateSortBy() {
	

		Home home = new Home();
		Category category = new Category();

		home.navigateToApparelAndShoes();
		MyAssertion.assertEquals(category.getTitle(), "Apparel & Shoes", "Category page title assertion");
		category.displayItemsPerPage(12);
		MyAssertion.assertEquals(category.getItemsCountOnPage(), 12, "Page items count assertion");
		category.sortBy("Price: Low to High");
		MyAssertion.assertTrue(category.isPricesSortedByAscending(), "Prices List is sorted order");
		Assertions.assertThat(category.isPricesSortedByAscending()).isEqualTo(true); //Fluent assertion
		

	}

	@Test(priority = 3, enabled = true)
	public void scenarioCompareList() {

		Home home = new Home();
		home.chooseCameraFromElectronics();

		Category category = new Category();
		category.addItemsToCompareList(1);
		home.chooseCameraFromElectronics();
		CompareList compare = category.addItemsToCompareList(2);
		MyAssertion.assertTrue(compare.isCompareListMatched(category.pricesOnProductDetailsPage),
				"Assertion for compare list price validation");

	}

	@Test(priority = 4, enabled = true)
	public void scenarioReviewValidation() {

		Home home = new Home();
		home.chooseCellPhonesFromElectronics();
		Category category = new Category();

		ProductDetails product = category.clkProduct(1);
		Review review = product.clkAddReview();
		MyAssertion.assertEquals(review.getPageTitle(), "Product reviews for Smartphone", "Review page title");
		review.postAReview();
		MyAssertion.assertEquals(review.validateSuccessMessage(), "Product review is successfully added.",
				"Review success message");
		MyAssertion.assertTrue(review.validateReview(), "Review validation");

	}

	@Test(priority = 5, enabled = true)
	public void scenarioWishList() {

		Home home = new Home();
		home.chooseCellPhonesFromElectronics();

		Category category = new Category();
		ProductDetails product = category.clkProduct(1);

		WishList wishList = product.addToWishList();

		MyAssertion.assertEquals(wishList.getPageTitle(), "Wishlist", "WishList page title");
		MyAssertion.assertEquals(wishList.numOfItemsInWishList(), 1, "Number of items in wishlist");
		wishList.removeAllFromWishList();
		MyAssertion.assertTrue(wishList.isWishListEmpty(), "Empty wishlist");

	}

}
