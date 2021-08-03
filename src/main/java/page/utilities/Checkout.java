package page.utilities;



import page.elements.CheckoutPage;


public class Checkout {

	CheckoutPage checkout;
	ExcelUtil ex;
	
	public Checkout() {
		
		checkout = new CheckoutPage();
		ex = new ExcelUtil();
		
	}
	
	public Success checkout() {
		fillBillingAddress();
		shippingAddress();
		shippingMethod();
		selectPaymentMethod();
		checkPaymentInfo();
		return confirmOrder();
	}
	
	public void fillBillingAddress() {
		
		checkout.selectFromDropdown(checkout.country(), "India");
		checkout.city().sendKeys(ex.getCellValue("City", 2));
		checkout.address().sendKeys(ex.getCellValue("Address", 2));
		checkout.zipCode().sendKeys(ex.getCellValue("Zip", 2));
		checkout.phoneNumber().sendKeys(ex.getCellValue("Phone", 2));
		checkout.jsClick(checkout.continueBtn());

	}
	
	public String getPageTitle() {
		return checkout.title().getText();
		
		
	}
	
	public void shippingAddress(){
		
		checkout.jsClick(checkout.shippingContinue());
		
	}
	
	public void shippingMethod() {
		checkout.jsClick(checkout.shippingMethodContinue());
		
	}
	
	public void selectPaymentMethod() {
		
		checkout.cashOnDelivery().click();
		checkout.jsClick(checkout.paymentMethodContinue());
	}
	
	public void checkPaymentInfo() {
		checkout.jsClick(checkout.paymentInfoContinue());
	}
	
	public Success confirmOrder() {
		checkout.jsClick(checkout.confirmBtn());
		return checkout.createNewInstance();
	}
	
}
