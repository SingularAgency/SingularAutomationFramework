package com.bkgt.pages.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bkgt.pages.details.ProductDrinks;

import io.appium.java_client.AppiumDriver;

public class ProductDrinksTasks extends ProductDrinks{
	public int maxDrinks;

	public ProductDrinksTasks(AppiumDriver driver) {
		super(driver);
		createSingleDrinks();
		createDrinks();
	}
	public void createSingleDrinks() {
		singleDrinks.put("Pepsi", rbtPepsi);
		singleDrinks.put("7 UP", rbt7Up);
		singleDrinks.put("Te Limon", rbtTeLimon);
		singleDrinks.put("Te Durazno", rbtTeDurazno);
		singleDrinks.put("Pepsi Black", rbtPepsiBlack);
		singleDrinks.put("Mirinda", rbtMirinda);
		singleDrinks.put("Grapette", rbtGrapette);
		singleDrinks.put("Pepsi 1.5L", rbtPepsi1L);
		singleDrinks.put("Agua", rbtAgua);

	}
	public void createDrinks() {
		drinks.put("Pepsi", pepsiElement);
		drinks.put("7 UP", sevenUpElement);
		drinks.put("Mirinda", mirindaElement);
		drinks.put("Grapette", grapetteElement);
		drinks.put("Cafe 16", cafe16Element);
		drinks.put("Cafe 16 con Leche", cafe16ConLecheElement);
		
	}
	public int getMaxCounters(String text) {
		Pattern pattern = Pattern.compile("(?<=\\D)\\d");
		Matcher matcher = pattern.matcher(text);

		if (matcher.find()) {
			String secondDigitString = matcher.group();
			int secondDigit = Integer.parseInt(secondDigitString);
			return secondDigit;

		}
		return 0;
	}

}
