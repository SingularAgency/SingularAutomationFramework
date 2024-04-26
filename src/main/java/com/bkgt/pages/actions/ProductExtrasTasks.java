package com.bkgt.pages.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bkgt.pages.details.ProductExtras;

import io.appium.java_client.AppiumDriver;

public class ProductExtrasTasks extends ProductExtras{
	public int maxExt;

	public ProductExtrasTasks(AppiumDriver driver) {
		super(driver);
		createExtras();
		// TODO Auto-generated constructor stub
	}
	
	

	public void createExtras() {
		extras.put("Dip Agridulce", dipAgridulce);
		extras.put("Dip Ranch", dipRanch);
		extras.put("Dip Bbw", dipBBQ);
		extras.put("Mas Mozzarella", masMozarella);
		extras.put("Extra Jamon", extraJamon);
		extras.put("Extra Carne W", extraCarneW);
		extras.put("Extra BBQ", extraBBQ);
		extras.put("Extra Suizo", extraSuizo);
		extras.put("Mas Jamon", masJamon);
		extras.put("Mas Pepinillos", masPepinillos);
		extras.put("Mas Queso", masQueso);
		extras.put("Mas Tocino", masTocino);
		extras.put("Extra Tocino", extraTocino);

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
