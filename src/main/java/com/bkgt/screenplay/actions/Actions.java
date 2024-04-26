package com.bkgt.screenplay.actions;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;

public class Actions {


	public static void scrollDown(AppiumDriver driver) {
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

		int startX = driver.manage().window().getSize().getWidth() / 2;
		int startY = driver.manage().window().getSize().getHeight() / 2;
		Point start = new Point(startX,startY);

		int endY = (int) (driver.manage().window().getSize().getHeight() * 0.2);
		Point end = new Point(startX,endY);
		
		Sequence swipe = new Sequence(finger, 1)
				.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.getX(),
						start.getY()))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(finger.createPointerMove(Duration.ofMillis(250), PointerInput.Origin.viewport(), end.getX(),
						end.getY()))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(swipe));
	}
	
	public static void scrollDown2Times(AppiumDriver driver) {
		scrollDown(driver);
		scrollDown(driver);

		
	}
	

	public void scrollUp(AppiumDriver driver) {
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

		Point end = new Point(576, 1516);
		Point start = new Point(599, 854);
		Sequence swipe = new Sequence(finger, 1)
				.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.getX(),
						start.getY()))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), end.getX(),
						end.getY()))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(swipe));

	}

	public void scrollLeft(AppiumDriver driver) throws InterruptedException {
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

		Point start = new Point(100, 375);
		Point end = new Point(900, 375);
		Sequence swipe = new Sequence(finger, 1)
				.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.getX(),
						start.getY()))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), end.getX(),
						end.getY()))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(swipe));

	}

	public void scrollRight(AppiumDriver driver) throws InterruptedException {
		
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

		Point end = new Point(100, 375);
		Point start = new Point(900, 375);
		Sequence swipe = new Sequence(finger, 1)
				.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.getX(),
						start.getY()))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), end.getX(),
						end.getY()))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(swipe));
	}
	
	public static void scrollRightiOS(AppiumDriver driver) {

		Point end = new Point(100, 200);
		Point start = new Point(900, 200);
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.getX(), start.getY()));
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(250), PointerInput.Origin.viewport(), end.getX(), end.getY()));
		
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(swipe));

	}
}
