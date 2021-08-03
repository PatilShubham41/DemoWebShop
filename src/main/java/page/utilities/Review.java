package page.utilities;

import page.elements.ReviewPage;

public class Review {
	
	private ReviewPage reviewPage;
	private ExcelUtil ex;
	private String reviewTitle;
	
	public Review(){
		reviewPage = new ReviewPage();
		ex = new ExcelUtil();
	}
	
	public String getPageTitle() {
		
		return reviewPage.title().getText();
		
	}
	
	public void postAReview() {
		
		reviewTitle = Utilities.randomStringGenerator(7);
		
		reviewPage.reviewTitle().sendKeys(reviewTitle);
		reviewPage.reviewText().sendKeys(ex.getCellValue("Review text", 2));
		reviewPage.reviewStar(Integer.parseInt(ex.getCellValue("Review stars", 2))).click();
		reviewPage.submitReviewBtn().click();

	}
	
	public String validateSuccessMessage() {
		
		return reviewPage.submissionSuccess().getText();
		
	}
	
	public boolean validateReview() {
		reviewPage.jsClick(reviewPage.submittedReview(reviewTitle));
		return reviewPage.submittedReview(reviewTitle).isDisplayed();
	}
	

}
