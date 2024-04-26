package BKGT.AppiumFramework.products;

import io.appium.java_client.AppiumDriver;

public class ComboReconciliacion extends Product{

	public AppiumDriver driver;
	
	String[] drinks = { "Pepsi","7 UP","Grapette"};
	String [] dips = {"Dip Agridulce","Dip Ranch","Dip Bbw"};
	


	public ComboReconciliacion(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;

	}
	
	
	public void addExtras() throws InterruptedException {
		waitForElement(mods.extrasContainer);
		mods.setMaxExtras();
		addCounters(dips, mods.extras,mods.maxExt);
	}
	
	public void addDrinks() throws InterruptedException {
		waitForElement(mods.drinksContainer);
		mods.setMaxDrinks();
		addCounters(drinks, mods.drinks,mods.maxDrinks);
	}
	
	public void addFries() {
		mods.fries.click();
		mods.fries.click();
		
	}
	
	public void addDesserts() {
		mods.chkManzanaPay.click();
		mods.chkQuesoPay.click();
	}


	

	
	
}
