package BKGT.AppiumFramework.products;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class Detalle {

	AppiumDriver driver;
	
	
	protected WebDriverWait wait;

	
	public Detalle(AppiumDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
// TODO Auto-generated constructor stub
	}
	
	public void agregarExtra(WebElement extra) {
		extra.click();
	}
	
	public void agregarPostre(WebElement postre) {
		postre.click();
	}
	
	public void agregarAcompañamiento(WebElement acompañamiento) {
		 wait.until(ExpectedConditions.visibilityOf(acompañamiento));

		acompañamiento.click();
	}
	
	public void agregarBebida(WebElement bebida) {
		 wait.until(ExpectedConditions.visibilityOf(bebida));

		bebida.click();
	}
	
	public void agregarAlCarrito() {
	}
	
	public String getProductName() {
		String locator="//android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.TextView[1]";
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		 return driver.findElement(By.xpath(locator)).getText();
		 
	}
	
	
	
	

	
	

}
