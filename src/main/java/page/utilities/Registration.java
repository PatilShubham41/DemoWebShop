package page.utilities;



import page.elements.RegisterPage;

public class Registration {
	RegisterPage registerPage;
	public static ExcelUtil ex;
	
	public Registration() {
		
		registerPage =  new RegisterPage();
		ex = new ExcelUtil();

	}
	
	public void navigateToRegister() {
		registerPage.navigateTo().click();
		
	}

	public void register() {
		
		navigateToRegister();
		registerPage.genderMale().click();
		registerPage.firstName().sendKeys(ex.getCellValue("Firstname", 2));
		registerPage.lastName().sendKeys(ex.getCellValue("Lastname", 2));
		registerPage.email().sendKeys(Utilities.randomStringGenerator(5)+"@ABC.com");
		registerPage.password().sendKeys(ex.getCellValue("password", 2));
		registerPage.confirmPassword().sendKeys(ex.getCellValue("password", 2));
		registerPage.register().click();

	}
	

}
