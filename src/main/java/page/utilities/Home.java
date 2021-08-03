package page.utilities;



import page.elements.HomePage;
import page.elements.PageBaseClass;

public class Home {
	
	HomePage home;
	ExcelUtil ex;
	
	public Home() {
		
		home = new HomePage();
		
	}
	
	public void navigateToApparelAndShoes() {
		
		home.apparelAndShoes().click();
		
	}
	
	public void chooseCameraFromElectronics() {
		
		PageBaseClass.mouseHover(home.electronics());
		home.camera().click();

	}
	
	public void chooseCellPhonesFromElectronics() {
		
		PageBaseClass.mouseHover(home.electronics());
		home.cellPhones().click();

	}
	

}
