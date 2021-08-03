package page.utilities;



import page.elements.LoginPage;

public class Login {
	
	LoginPage loginPage;
	ExcelUtil ex;
	
	public Login() {
		
		loginPage = new LoginPage();
		ex = new ExcelUtil();
		
	}
	
	public void doLogin() {
		
		try {
			
			loginPage.logOut().isDisplayed();
			loginPage.continueBtn().isDisplayed();
			loginPage.continueBtn().click();
			
		}catch(Exception e) {
			loginPage.navigateTo().click();
			loginPage.email().sendKeys(ex.getCellValue("email", 2));
			loginPage.password().sendKeys(ex.getCellValue("password", 2));
			loginPage.login().click();
		}

		
	}

}
