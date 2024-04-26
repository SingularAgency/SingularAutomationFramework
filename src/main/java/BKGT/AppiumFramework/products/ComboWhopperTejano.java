package BKGT.AppiumFramework.products;

import io.appium.java_client.android.AndroidDriver;

public class ComboWhopperTejano extends Product {
	public AndroidDriver driver;

	String[] drinks = { "Pepsi", "7 UP", "Te Limon", "Te Durazno", "Pepsi Black" };

	ComboWhopperTejano(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	public void addAcomps() {
		addSingles(mods.singleAcomp);
	}

	public void addDrinks() throws InterruptedException {
		waitForElement(mods.drinksContainer);
		addSingles(drinks, mods.drinks);
	}

}
