package page.utilities;



import page.elements.SuccessPage;

public class Success {
	
	SuccessPage success;
	ExcelUtil ex;
	
	public Success() {
		
		success = new SuccessPage();
		ex = new ExcelUtil();
	}
	
	
	public String pageTitle() {
		return success.title().getText();
	}
	
	public String getSuccessMessage() {
		return success.successMessage().getText();
	}

}
