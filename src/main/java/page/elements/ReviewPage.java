package page.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReviewPage extends PageBaseClass {

	public WebElement title() {

		return driver.findElement(By.cssSelector("div.page-title>h1"));
	}

	public WebElement reviewTitle() {

		return driver.findElement(By.id("AddProductReview_Title"));

	}

	public WebElement reviewText() {
		return driver.findElement(By.id("AddProductReview_ReviewText"));
	}

	public WebElement reviewStar(int stars) {
		return driver.findElement(By.id("addproductrating_" + stars + ""));
	}

	public WebElement submitReviewBtn() {
		return driver.findElement(By.name("add-review"));
	}

	public WebElement submissionSuccess() {
		return driver.findElement(By.cssSelector("div.result"));
	}

	public WebElement submittedReview(String reviweTitle) {
		return driver
				.findElement(By.xpath("//div[@class='product-review-list']//div[@class='review-title']/strong[text()='"
						+ reviweTitle + "']"));
	}

}
