package BKGT.AppiumFramework.products;

import io.appium.java_client.android.AndroidDriver;

public class KingPolloAmericano extends Product{
	
public AndroidDriver driver;
	
	String [] extras = {"Extra Jamon","Mas Mozarella"};
	


	public KingPolloAmericano(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;

	}
	
	public void addExtras() throws InterruptedException {
		waitForElement(mods.extrasContainer);
		mods.setMaxExtras();
		addCounters(extras, mods.extras,mods.maxExt);
	}
	
}
