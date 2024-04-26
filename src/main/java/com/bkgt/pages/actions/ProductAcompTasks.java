package com.bkgt.pages.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bkgt.pages.details.ProductAcomp;

import io.appium.java_client.AppiumDriver;

public class ProductAcompTasks extends ProductAcomp{

	public int maxAcomp;

	public ProductAcompTasks(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		createAccomp();
		createSingleAcomp();
	}

	public void createSingleAcomp() {
		singleAcomp.put("Papas Medianas", rbtPapasMed);
		singleAcomp.put("Papas Grandes", rbtPapasG);
		singleAcomp.put("Aros Medianos", rbtArosMed);
		singleAcomp.put("Aros  Grandes", rbtArosG);
		singleAcomp.put("Aros", rbtAros);
		singleAcomp.put("Papas", rbtPapas);
	}
	
	public void createAccomp() {
		acomp.put("Papas Medianas", addMedDries);
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



	public void setMaxAcomp() {
		maxAcomp = getMaxCounters(acompContainer.getText());

	}
	
}
