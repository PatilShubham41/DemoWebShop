package page.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import page.elements.CompareListPage;

public class CompareList {

	private CompareListPage compare;

	public CompareList() {

		compare = new CompareListPage();
	}

	public int getCompareListSize() {

		return compare.items().size();
	}

	public List<WebElement> getPrices() {

		return compare.prices();
	}

	public boolean isCompareListMatched(ArrayList<Float> pricesOnProductDetailsPage) {
		
		boolean flag = true;
		int index =0;
		for (WebElement ele : getPrices()) {
			
			System.out.println("Price on product page: "+pricesOnProductDetailsPage.get(index)+" Price on compare list: "+ele.getText());
			if(Float.parseFloat(ele.getText())== pricesOnProductDetailsPage.get(index))
				System.out.println("Prices matched");
			else {
				System.out.println("Prices didn't match");
				flag = false;
			}
				
				
			
			index++;
		}
		
		return flag;

	}

}
